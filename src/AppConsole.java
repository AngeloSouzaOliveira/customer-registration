import dao.CustomerMapDAO;
import dao.ICustomerDAO;
import domain.Customer;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppConsole {
    public static void main(String[] args) {

        ICustomerDAO customerMapDAO = new CustomerMapDAO();

        Scanner read = new Scanner(System.in);

        Integer option = 0;
        Boolean loop = true;

        print("*** Welcome to your customer register ***\n");
        while (loop){
            print("Insert...\n" +
                    "1 - Register a customer\n" +
                    "2 - Consult a customer\n" +
                    "3 - Update a customer\n" +
                    "4 - Remove a customer\n" +
                    "5 - See all customers\n" +
                    "6 - Exit"
            );

                option = read.nextInt();


                switch (option){
                    case 1:
                        System.out.println("Enter customer name:");
                        String name = read.next();
                        name += read.nextLine();

                        System.out.println("Enter customer CPF:");
                        String textCpf = read.next().replaceAll("[^\\d\\s]", "");
                        Long cpf = Long.parseLong(textCpf);

                        System.out.println("Enter customer phone number:");
                        String textPhone = read.next().replaceAll("[^\\d\\s]", "");
                        Long phone = Long.parseLong(textPhone);

                        System.out.println("Enter customer address:");
                        String address = read.next();
                        address += read.nextLine();

                        System.out.println("Enter customer house number:");
                        String number = read.next();
                        number += read.nextLine();

                        System.out.println("Enter customer city:");
                        String city = read.next();
                        city += read.nextLine();

                        System.out.println("Enter customer state:");
                        String state = read.next();
                        state += read.nextLine();

                        Customer customer = new Customer(name, cpf, phone, address, number, city, state);
                        customerMapDAO.register(customer);

                        break;

                    case 2:
                        System.out.println("Enter customer CPF to search:");
                        String cpfTxtConsult = read.next().replaceAll("[^\\d\\s]", "");
                        Long cpfConsult = Long.parseLong(cpfTxtConsult);
                        Customer consultCustomer = customerMapDAO.consult(cpfConsult);
                        if (consultCustomer != null) {
                            System.out.println("Consulted customer details:\n" + consultCustomer);
                        } else {
                            System.out.println("Customer not found.");
                        }
                        break;

                    case 3:
                        System.out.println("Enter the cpf of the customer to be updated:");
                        String cpfTxtUpdate = read.next().replaceAll("[^\\d\\s]", "");
                        Long cpfUpdate = Long.parseLong(cpfTxtUpdate);

                        System.out.println("Enter new customer name:");
                        String nameUpdate = read.next();
                        nameUpdate += read.nextLine();

                        System.out.println("Enter new customer phone number:");
                        String phoneTxtUpdate = read.next().replaceAll("[^\\d\\s]", "");
                        Long phoneUpdate = Long.parseLong(phoneTxtUpdate);

                        System.out.println("Enter new customer address:");
                        String addressUpdate = read.next();
                        addressUpdate += read.nextLine();

                        System.out.println("Enter new customer house number:");
                        String numberUpdate = read.next();
                        numberUpdate += read.nextLine();

                        System.out.println("Enter new customer city:");
                        String cityUpdate = read.next();
                        cityUpdate += read.nextLine();

                        System.out.println("Enter new customer state:");
                        String stateUpdate = read.next();
                        stateUpdate += read.nextLine();

                        Customer customerUpdate = new Customer(nameUpdate,cpfUpdate, phoneUpdate, addressUpdate, numberUpdate, cityUpdate, stateUpdate);
                        customerMapDAO.update(customerUpdate);

                        break;

                    case 4:
                        print("Enter customer CPF to remove:");
                        String cpfTxtRemove = read.next().replaceAll("[^\\d\\s]", "");
                        Long cpfRemove = Long.parseLong(cpfTxtRemove);
                        customerMapDAO.remove(cpfRemove);
                        break;

                    case 5:

                        if(customerMapDAO.allCustomers().size() <= 0){
                            print("There are no registered customers!");
                        } else {
                            print("All registered customers:");
                            for (Customer aloneCustomer : customerMapDAO.allCustomers()){
                                print(String.valueOf(aloneCustomer));

                            }
                        }

                        break;

                    case 6:
                        print("Exit to the program!");
                        loop = false;
                        break;

                    default:
                        print("Invalid option!");
                }


        }
    }

    public static void print(String value){
        System.out.println(value);
    }


}