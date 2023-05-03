package src.repository;

import src.model.Client;

import java.util.List;

public interface ClientRepository {
    //
    Client findByAccount(String accountNumber);

    List<Client> findAll();
}
