package com.mertoatakan.hw2;

import com.mertoatakan.hw2.entity.CorporateCustomer;
import com.mertoatakan.hw2.entity.IndividualCustomer;
import com.mertoatakan.hw2.entity.Invoice;
import com.mertoatakan.hw2.service.CustomerService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();

        CorporateCustomer corporateCustomer1 = new CorporateCustomer("ABC Corp", LocalDate.of(2022, 6, 15), "123456789", "Teknoloji");
        customerService.addCustomer(corporateCustomer1);

        CorporateCustomer corporateCustomer2 = new CorporateCustomer("XYZ Enterprises", LocalDate.of(2022, 5, 10), "987654321", "Üretim");
        customerService.addCustomer(corporateCustomer2);

        IndividualCustomer individualCustomer1 = new IndividualCustomer("John Doe", LocalDate.of(2022, 4, 20), "personalID123");
        customerService.addCustomer(individualCustomer1);

        customerService.addInvoice(new Invoice(corporateCustomer1.getId(), 500, LocalDate.of(2022, 6, 10)));
        customerService.addInvoice(new Invoice(corporateCustomer1.getId(), 300, LocalDate.of(2022, 6, 20)));
        customerService.addInvoice(new Invoice(corporateCustomer2.getId(), 9000, LocalDate.of(2022, 5, 15)));
        customerService.addInvoice(new Invoice(individualCustomer1.getId(), 250, LocalDate.of(2022, 4, 22)));


        System.out.println("Tüm Müşteriler:");
        customerService.listAllCustomers();

        System.out.println("\n'C' Harfi İçeren Müşteriler:");
        customerService.listCustomersWithC();

        System.out.println();
        customerService.listTotalOfJuneInvoices();

        System.out.println("\nSistemdeki Tüm Faturalar:");
        customerService.listAllInvoices();

        System.out.println("\n1500TL Üstündeki Faturalar:");
        customerService.listInvoicesOver1500();

        System.out.println();
        customerService.averageOfInvoicesOver1500();

        System.out.println("\n500TL Altındaki Faturalara Sahip Müşterilerin İsimleri:");
        customerService.listCustomersWithInvoicesUnder500();

        System.out.println("\nHaziran Ayını Faturalarının Ortalaması 750TL Altında Olan Firmaların Sektörleri:");
        customerService.listSectorsWithAverageInvoicesBelow750InJune();


    }
}
