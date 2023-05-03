package src.service;

import src.model.Client;
import src.repository.ClientRepository;

import java.util.List;

public class ClientService {
    //сервисный слой
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findByAccount(String accountNumber) {
        return clientRepository.findByAccount(accountNumber);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
