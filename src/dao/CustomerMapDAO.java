package dao;

import domain.Customer;

import java.util.*;

public class CustomerMapDAO implements ICustomerDAO {

    private Map<Long, Customer> map;

    public CustomerMapDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean register(Customer customer) {

        if (this.map.containsKey(customer.getCpf())) {
            System.out.println("Customer already registered!");
            return false;
        }

        this.map.put(customer.getCpf(), customer);

        return true;
    }

    @Override
    public Customer consult(Long cpf) {
        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void remove(Long cpf) {

    }

    @Override
    public Collection<Customer> allCustomers() {
        return null;
    }
}
