package domain;

import java.util.Objects;

public class Customer {
    private String name;
    private Long cpf;
    private Long phone;
    private String address;
    private Integer number;
    private String city;
    private String state;

    public Customer(String name, Long cpf, Long phone, String address, Integer number, String city, String state) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.address = address;
        this.number = number;
        this.city = city;
        this.state = state;
    }

    public Customer(String name, Long phone, String address, Integer number, String city, String state) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.number = number;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(cpf, customer.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Customer: " +
                "\n-name='" + name + '\'' +
                ",\n-cpf=" + cpf +
                ",\n-phone=" + phone +
                ",\n-address='" + address + '\'' +
                ",\n-number=" + number +
                ",\n-city='" + city + '\'' +
                ",\n-state='" + state + '\'';
    }
}
