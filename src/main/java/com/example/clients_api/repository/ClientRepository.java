package com.example.clients_api.repository;

import com.example.clients_api.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {
    Page<Client> findByFirstNameContaining(String firstName, Pageable pageable);
}
