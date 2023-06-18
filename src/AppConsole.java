import dao.CustomerMapDAO;
import dao.ICustomerDAO;
import domain.Customer;

import java.util.Scanner;

public class AppConsole {
    public static void main(String[] args) {
        ICustomerDAO customerMapDAO = new CustomerMapDAO();

        Scanner read = new Scanner(System.in);
        Integer option = 0;

        do{
            print("*** Welcome to your customer register ***\n");
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
                    print("Insira o nome do cliente:");
                    String name = read.next();
                    name += read.nextLine();

                    print("Insira o cpf:");
                    Long cpf = read.nextLong();

                    print("Insira o telefone:");
                    Long phone = read.nextLong();

                    print("Insira o  endereço:");
                    String address = read.next();
                    address += read.nextLine();

                    print("Insira o número do numero:");
                    Integer number = read.nextInt();

                    print("Insira a cidade:");
                    String city = read.next();
                    city += read.nextLine();

                    print("Insira o estado:");
                    String state = read.next();
                    state += read.nextLine();

                    Customer customer = new Customer(name, cpf, phone, address, number, city, state);
                    customerMapDAO.register(customer);

                    break;

                case 2:
                    print("Insirira o cpf do cliente:");
                    Long cpfConsult = read.nextLong();
                    customerMapDAO.consult(cpfConsult);
                    break;

                case 3:
                    print("Insira o nome do cliente:");
                    String nameUpdate = read.next();

                    print("Insira o telefone:");
                    Long phoneUpdate = read.nextLong();

                    print("Insira o  endereço:");
                    String addressUpdate = read.next();

                    print("Insira o número do numero:");
                    Integer numberUpdate = read.nextInt();

                    print("Insira a cidade:");
                    String cityUpdate = read.next();

                    print("Insira o estado:");
                    String stateUpdate = read.next();

                    Customer customerUpdate = new Customer(nameUpdate, phoneUpdate, addressUpdate, numberUpdate, cityUpdate, stateUpdate);
                    customerMapDAO.update(customerUpdate);
                    break;

                case 4:
                    print("Insirira o cpf do cliente a ser removido:");
                    Long cpfRemove = read.nextLong();
                    customerMapDAO.remove(cpfRemove);
                    break;

                case 5:
                    print("Todos os clientes registrados:");
                    customerMapDAO.allCustomers();
                    break;

                default:
                    print("Invalid option!");
            }
        } while (option != 6);
    }

    public static void print(String value){
        System.out.println(value);
    }


}