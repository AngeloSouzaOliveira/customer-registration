package dao;

import domain.Customer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CustomerSetDAO implements ICustomerDAO{

    private Set<Customer> set = new HashSet<>();

    public CustomerSetDAO() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean register(Customer customer) {
        if(customer != null){
            set.add(customer);
            return true;
        } else{
            return false;
        }

    }

    @Override
    public Customer consult(Long cpf) {
        if(cpf != null){
            Customer customerFound = null;
            Iterator<Customer> customerIterator = set.iterator();

            while (customerIterator.hasNext()){
                Customer customerConsul = customerIterator.next();
                if(customerConsul.getCpf().equals(cpf)){
                    customerFound = customerConsul;
                }
            }
            return customerFound;

        } else {
            return null;
        }
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
