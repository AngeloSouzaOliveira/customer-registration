import dao.CustomerMapDAO;
import dao.ICustomerDAO;
import domain.Customer;

import javax.swing.*;
import java.util.Scanner;

public class AppSpring {
    private static ICustomerDAO iCustomerDAO;
    public static void main(String[] args) {
        iCustomerDAO = new CustomerMapDAO();
        String option = JOptionPane.showInputDialog(null,
                "Enter 1 for registration, " +
                "2 for consultation, 3 for deletion, " +
                "4 for updating, 5 to exit.",
                "Customer Registration", JOptionPane.INFORMATION_MESSAGE);
        while (!isValid(option)){
            if("".equals(option)){
                sair();
            }
            option = JOptionPane.showInputDialog(null,"Invalid " +
                    "option! Enter 1 for registration, " +  "2 for consultation, " +
                    "3 for deletion, 4 for updating, 5 to exit",
                    "Customer Registration", JOptionPane.INFORMATION_MESSAGE);
        }
        while (isValid(option)){
            if(isExitOption(option)){
                sair();
            } else if (isOptionRegister(option)){
                String data = JOptionPane.showInputDialog(null,"Enter data separated by a comma. Example: Name, CPF, Telephone, Address, Number, City, State",
                        "Customer Registration", JOptionPane.INFORMATION_MESSAGE);
                registerCustomer(data);
            } else if (isOptionConsult(option)) {
                String cpf = JOptionPane.showInputDialog(null,"Enter the customer's CPF:", "Consult customer", JOptionPane.INFORMATION_MESSAGE);
                consultCustomer(cpf);
            } else if (isOptionDelete(option)) {
                String cpf = JOptionPane.showInputDialog(null,"Enter the customer's CPF if removed:", "Remove customer", JOptionPane.INFORMATION_MESSAGE);
                removeCustomer(cpf);
            } else if (isOptionUpdate(option)) {
                String CPF = JOptionPane.showInputDialog(null,"Enter the CPF of the customer to be updated:", "Update customer", JOptionPane.INFORMATION_MESSAGE);
                uptadeCustomer(CPF);
            }
            option = JOptionPane.showInputDialog(null,
                    "Enter 1 for registration, " +
                            "2 for consultation, 3 for deletion, " +
                            "4 for updating, 5 to exit.",
                    "Customer Registration", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private static void uptadeCustomer(String cpf){
        if(cpf != null){
            Customer customer = iCustomerDAO.consult(Long.parseLong(cpf.replaceAll("[^\\d\\s]", "")));
            String data = JOptionPane.showInputDialog(null,"Enter data separated by a comma. Example: Name, Telephone, Address, Number, City, State",
                    "Customer Update", JOptionPane.INFORMATION_MESSAGE);
            String[] separeData = data.split(",");
            Customer customerUptade = new Customer(separeData[0], Long.parseLong(separeData[1]), separeData[2], separeData[3], separeData[4], separeData[5]);
            customer.setName(customerUptade.getName());
            customer.setPhone(customerUptade.getPhone());
            customer.setAddress(customerUptade.getAddress());
            customer.setNumber(customerUptade.getNumber());
            customer.setCity(customerUptade.getCity());
            customer.setState(customerUptade.getState());
            Boolean isUptade = iCustomerDAO.update(customer);
            if(isUptade){
                JOptionPane.showMessageDialog(null, "Customer updated successfully!",
                        "Successfully", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Customer not found!",
                        "Not found", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    private static boolean isOptionUpdate(String option) {
        if("4".equals(option)){
            return true;
        } else {
            return false;
        }
    }
    private static void removeCustomer(String cpf) {
        if(cpf != null) {
            //Validar se o que foi passado foi o cpf
            Long cpfCustomer = Long.parseLong(cpf.replaceAll("[^\\d\\s]", ""));
            Boolean isRemove = iCustomerDAO.remove(cpfCustomer);
            if(isRemove) {
                JOptionPane.showMessageDialog(null, "Client removed successfully!",
                        "Successfully", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Customer not found!",
                        "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    private static boolean isOptionDelete(String option) {
        if("3".equals(option)){
            return  true;
        }
        return false;
    }
    private static void consultCustomer(String cpf) {
        if(cpf != null) {
            //Validar se o que foi passado foi o cpf
            Long cpfCustomer = Long.parseLong(cpf.replaceAll("[^\\d\\s]",""));
            Customer customer = iCustomerDAO.consult(cpfCustomer);
            if(customer != null){
                JOptionPane.showMessageDialog(null, "Customer was found:\n" + customer.toString(),
                        "Customer was found", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Client not found!", "Not Found", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    private static boolean isOptionConsult(String option) {
        if("2".equals(option)) {
            return  true;
        }
        return false;
    }
    private static void  registerCustomer(String data){
        // Tentar validade se os campos estão preenciado
        // se não tiver passar null no construtor
        //  Customer customer = new Customer(separateData[0],Long.parseLong(separateData[1]), null, null,null,null, null;
        //validar tipo de dado
        String[] separateData = data.split(",");
        Customer customer = new Customer(separateData[0],Long.parseLong(separateData[1]),
                Long.parseLong(separateData[2]), separateData[3],separateData[4],
                separateData[5], separateData[6]);
        Boolean isRegister = iCustomerDAO.register(customer);
        if (isRegister) {
            JOptionPane.showMessageDialog(null, "Successfully registered customer!",
                    "Successfully", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Customer is already registered!",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private static boolean isExitOption(String option) {
        if("5".equals(option)){
            return true;
        }
        return false;
    }
    private static void sair() {
        JOptionPane.showMessageDialog(null, "See you later!", "Exit", JOptionPane.INFORMATION_MESSAGE );
        System.exit(0);
    }
    private static boolean isValid(String option) {
        if("1".equals(option) || "2".equals(option) || "3".equals(option) || "4".equals(option) || "5".equals(option)){
            return true;
        } else {
            return false;
        }
    }
    private static boolean isOptionRegister(String option) {
        if("1".equals(option)){
            return true;
        }
        return false;
    }
}