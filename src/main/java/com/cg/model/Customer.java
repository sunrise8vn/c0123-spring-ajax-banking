package com.cg.model;

import com.cg.model.dto.CustomerCreateResDTO;
import com.cg.model.dto.CustomerDTO;
import com.cg.model.dto.CustomerUpdateResDTO;
import lombok.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    private String phone;

    @Column(precision = 10, scale = 0, nullable = false, updatable = false)
    private BigDecimal balance;

    private String address;

    @OneToMany
    private List<Deposit> deposits;

    @OneToMany
    private List<Withdraw> withdraws;

    @OneToMany
    private List<Transfer> senders;

    @OneToMany
    private List<Transfer> recipients;


    public CustomerCreateResDTO toCustomerCreateResDTO() {
        return new CustomerCreateResDTO()
                .setId(id)
                .setFullName(fullName)
                .setEmail(email)
                .setPhone(phone)
                .setBalance(balance)
                .setAddress(address)
                ;

    }

    public CustomerUpdateResDTO toCustomerUpdateResDTO() {
        return new CustomerUpdateResDTO()
                .setId(id)
                .setFullName(fullName)
                .setEmail(email)
                .setPhone(phone)
                .setBalance(balance)
                .setAddress(address)
                ;

    }

    public CustomerDTO toCustomerDTO() {
        return new CustomerDTO()
                .setId(id)
                .setFullName(fullName)
                .setEmail(email)
                .setPhone(phone)
                .setBalance(balance)
                .setAddress(address)
                ;

    }


}
