package com.mertoatakan.hw2.service;

import com.mertoatakan.hw2.entity.BaseCustomer;
import com.mertoatakan.hw2.entity.CorporateCustomer;
import com.mertoatakan.hw2.entity.Invoice;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerService {
    private final List<BaseCustomer> customers = new ArrayList<>();
    private final List<Invoice> invoices = new ArrayList<>();

    // Yeni müşteri ekleme
    public void addCustomer(BaseCustomer customer) {
        this.customers.add(customer);
    }

    // Fatura ekleme
    public void addInvoice(Invoice invoice) {
        this.invoices.add(invoice);
    }

    // Tüm müşterileri listeleme
    public void listAllCustomers() {
        this.customers.forEach(BaseCustomer::printCustomerDetails);
    }

    // 'C' harfi içeren müşterileri listeleme
    public void listCustomersWithC() {
        this.customers.stream()
                .filter(c -> c.getName().contains("C"))
                .forEach(BaseCustomer::printCustomerDetails);
    }

    // Haziran ayında kayıt olan müşterilerin faturalarının toplam tutarını listeleyin
    public void listTotalOfJuneInvoices() {
        double total = invoices.stream()
                .filter(invoice -> invoice.getDate().getMonth() == Month.JUNE)
                .mapToDouble(Invoice::getAmount)
                .sum();
        System.out.println("Haziran ayı faturalarının toplam tutarı: " + total);
    }

    // Sistemdeki tüm faturaları listeleyin
    public void listAllInvoices() {
        invoices.forEach(invoice -> System.out.println("Fatura ID: " + invoice.getId() + ", Tutar: " + invoice.getAmount()));
    }

    // Sistemdeki 1500TL üstündeki faturaları listeleyin
    public void listInvoicesOver1500() {
        invoices.stream()
                .filter(invoice -> invoice.getAmount() > 1500)
                .forEach(invoice -> System.out.println("Fatura ID: " + invoice.getId() + ", Tutar: " + invoice.getAmount()));
    }

    // Sistemdeki 1500TL üstündeki faturaları ortalamasını hesaplayın
    public void averageOfInvoicesOver1500() {
        double average = invoices.stream()
                .filter(invoice -> invoice.getAmount() > 1500)
                .mapToDouble(Invoice::getAmount)
                .average()
                .orElse(0);
        System.out.println("1500TL üstündeki faturaların ortalaması: " + average);
    }

    // Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri listeleyin
    public void listCustomersWithInvoicesUnder500() {
        invoices.stream()
                .filter(invoice -> invoice.getAmount() < 500)
                .map(invoice -> customers.stream()
                        .filter(customer -> customer.getId() == invoice.getCustomerId())
                        .findFirst()
                        .orElse(null))
                .filter(java.util.Objects::nonNull)
                .forEach(customer -> System.out.println("Müşteri İsmi: " + customer.getName()));
    }

    public void listSectorsWithAverageInvoicesBelow750InJune() {
        Map<String, Double> averageInvoices = invoices.stream()
                .filter(invoice -> invoice.getDate().getMonth() == Month.JUNE)
                .collect(Collectors.groupingBy(invoice -> {
                    BaseCustomer customer = customers.stream()
                            .filter(c -> c.getId() == invoice.getCustomerId() && c instanceof CorporateCustomer)
                            .findFirst().orElse(null);
                    return customer != null ? ((CorporateCustomer) customer).getSector() : "Unknown";
                }, Collectors.averagingDouble(Invoice::getAmount)));

        averageInvoices.forEach((sector, average) -> {
            if (average < 750) {
                System.out.println("Sektör: " + sector + ", Haziran Ayı Ortalama Fatura: " + average);
            }
        });
    }

}
