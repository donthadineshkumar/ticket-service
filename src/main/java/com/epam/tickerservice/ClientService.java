package com.epam.tickerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public void createClient(Client client) {
        ClientDocument clientDocument = new ClientDocument();
        clientDocument.setLocation(client.getLocation());
        clientRepository.save(clientDocument);
    }
}
