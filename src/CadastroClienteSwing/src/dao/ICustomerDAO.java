package dao;

import domain.Customer;

import java.util.Collection;

public interface ICustomerDAO {

    public Boolean register(Customer customer);
    public Customer consult(Long cpf);
    public Boolean update(Customer customer);
    public Boolean remove(Long cpf);
    public Collection<Customer> allCustomers();

}
