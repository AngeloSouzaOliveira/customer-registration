package dao;

import domain.Customer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CustomerSetDAO implements ICustomerDAO{

    private Set<Customer> set = new HashSet<>();

    public CustomerSetDAO() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean register(Customer customer) {
        return null;
    }

    @Override
    public Customer consult(Long cpf) {
        return null;
    }

    @Override
    public Boolean update(Customer customer) {
        return null;
    }

    @Override
    public Boolean remove(Long cpf) {
        return null;
    }

    @Override
    public Collection<Customer> allCustomers() {
        return null;
    }
}
