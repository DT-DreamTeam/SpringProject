package com.project.MySSProject.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    private final UserAccountService userAccountService;
    @Override
    public Customer createCustomer(Customer customer) {
        Customer theCustomer = customerRepository.save(customer);
        userAccountService.createUserAccount(theCustomer);
        return theCustomer;
    }
}
