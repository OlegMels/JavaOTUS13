package src.repository;

import src.model.Account;
import src.model.Client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ClientRepositoryInMemoryImpl implements ClientRepository {
    //слой для связи с БД
    private final HashMap<Integer, Client> clients = new HashMap<>();
    private final HashMap<String, Account> accounts = new HashMap<>();

    public ClientRepositoryInMemoryImpl() {
        Client client1 = new Client(1, "Григорий Григорьевич Григорьев", LocalDate.of(1991, 5, 23));
        Account account11 = new Account(1, "40817810000000000001", client1);
        Account account12 = new Account(2, "40817810000000000002", client1);
        Account account13 = new Account(3, "40817810000000000003", client1);

        clients.put(client1.getId(), client1);
        accounts.put(account11.getNumber(), account11);
        accounts.put(account12.getNumber(), account12);
        accounts.put(account13.getNumber(), account13);

        Client client2 = new Client(2, "Василий Игнатьевич Пупкин", LocalDate.of(1980, 1, 7));
        Account account21 = new Account(4, "40817810000000000009", client2);
        Account account22 = new Account(5, "40817810000000000004", client2);

        clients.put(client2.getId(), client2);
        accounts.put(account21.getNumber(), account21);
        accounts.put(account22.getNumber(), account22);

        Client client3 = new Client(3, "Петр Петрович Петров", LocalDate.of(2000, 10, 14));
        clients.put(client3.getId(), client3);
    }

    @Override
    public Client findByAccount(String accountNumber) {
        Optional<Account> accountOptional = Optional.ofNullable(accounts.get(accountNumber));

        if (accountOptional.isPresent()) {
            return accountOptional
                    .get()
                    .getClient();
        } else {
            throw new IllegalArgumentException("Счет не найден");
        }
    }

    @Override
    public List<Client> findAll() {
        List<Client> clientsAsList = new ArrayList<>();

        for(int i = 0; i < clients.size(); i++){
            clientsAsList.add(clients.get(i+1));
        }

        return clientsAsList;
    }
}
