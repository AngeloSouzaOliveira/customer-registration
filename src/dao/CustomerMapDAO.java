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
            System.out.println("Customer already registered!\n");
            return false;
        }
        this.map.put(customer.getCpf(), customer);
        System.out.println("Customer registered sucess!\n");

        return true;
    }

    @Override
    public Customer consult(Long cpf) {
        if(this.map.containsKey(cpf)){
            System.out.println("Customer not registered!\n");
        }
        Customer consultCustomer = this.map.get(cpf);
        return consultCustomer;
    }

    @Override
    public Boolean update(Customer customer) {
        Customer updateCustomer = this.map.get(customer.getCpf());
        if(updateCustomer != null) {
            updateCustomer.setName(customer.getName());
            updateCustomer.setPhone(customer.getPhone());
            updateCustomer.setAddress(customer.getAddress());
            updateCustomer.setNumber(customer.getNumber());
            updateCustomer.setCity(customer.getCity());
            updateCustomer.setState(customer.getState());
            System.out.println("-> Client updated successfully:");
            System.out.println(updateCustomer);
            return true;

        } else {
            System.out.println("Customer not registered!\n");
            return false;
        }
    }

    @Override
    public Boolean remove(Long cpf) {
        Customer removerCustomer = this.map.get(cpf);
        if(removerCustomer != null){
            this.map.remove(removerCustomer.getCpf(), removerCustomer);
            System.out.println("Customer remove sucess!\n");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Collection<Customer> allCustomers() {
        return this.map.values();
    }
}
