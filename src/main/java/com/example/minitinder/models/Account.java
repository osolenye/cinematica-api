package com.example.minitinder.models;

import com.example.minitinder.models.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String login;
    String password;
    int count;
    @Enumerated(EnumType.STRING)
    AccountStatus status;


    Date addDate;
    Date updateDate;

    @PrePersist
    protected void onCreate() {
        addDate = new Date();
        updateDate = new Date();
        status = AccountStatus.ACTIVE;
        count = 0;
    }
    @PreUpdate
    protected void onUpdate() {
        updateDate = new Date();
    }
}
