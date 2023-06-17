package dao;

import domain.Customer;

import java.util.Collection;

public interface ICustomerDAO {

    public Boolean register(Customer customer);
    public Customer consult(Long cpf);
    public void update(Customer customer);
    public void remove(Long cpf);
    public Collection<Customer> allCustomers();

}
