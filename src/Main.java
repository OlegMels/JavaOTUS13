package src;

import src.repository.ClientRepository;
import src.repository.ClientRepositoryInMemoryImpl;
import src.service.ClientService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClientRepository clientRepository = new ClientRepositoryInMemoryImpl();
        ClientService clientService = new ClientService(clientRepository);

        Scanner sc;
        while (true) {
            System.out.println("Выберите действие: \n" +
                    "1 - получить список всех клиентов.  \n" +
                    "2 - получить клиента по номеру счета. \n" +
                    "3 - завершить программу."
            );

            sc = new Scanner(System.in);
            int action = sc.nextInt();

            switch (action) {
                case 1: {
                    clientService.findAll().forEach(System.out::println);
                    break;
                }
                case 2: {
                    System.out.println("Введите номер счета формата ********************:");
                    Scanner stingSc = new Scanner(System.in);
                    String accountNumber = stingSc.nextLine();

                    try {
                        System.out.println(clientService.findByAccount(accountNumber));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }
            }
        }
    }
}
