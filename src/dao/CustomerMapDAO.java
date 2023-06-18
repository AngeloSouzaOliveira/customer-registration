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
        Customer updateCustomer = this.map.get(customer.getCpf());

        if(updateCustomer != null){
            updateCustomer.setName(customer.getName());
            updateCustomer.setCpf(customer.getCpf());
            updateCustomer.setAddress(customer.getAddress());
            updateCustomer.setNumber(customer.getNumber());
            updateCustomer.setCity(customer.getCity());
            updateCustomer.setState(customer.getState().trim());
            updateCustomer.setPhone(customer.getPhone());

            System.out.println(updateCustomer);
        }

    }

    @Override
    public void remove(Long cpf) {
        Customer removerCustomer = this.map.get(cpf);
        if(removerCustomer != null){
            this.map.remove(removerCustomer.getCpf(), removerCustomer);
            System.out.println("Customer remove sucess!");
        }

    }

    @Override
    public Collection<Customer> allCustomers() {
        return null;
    }
}
