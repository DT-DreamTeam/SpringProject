package com.project.MySSProject.security;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.MySSProject.auth.Role;
import com.project.MySSProject.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserAccount {


    private Long userAccountId;


    private String userName;


    private String password;

    @OneToMany(
            fetch= FetchType.EAGER,
            mappedBy = "userAccount",
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH,
                    CascadeType.PERSISTg
            }
    )
    private Set<Role> roles = new HashSet<>();git pus

    @OneToOne(
            fetch=FetchType.EAGER,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            }
    )
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    private boolean isAccountNonExpired;//TolegenDii
//37 мин
}
