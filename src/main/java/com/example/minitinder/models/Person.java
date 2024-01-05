package com.example.minitinder.models;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String secondName;
    int age;
    String info;

    @OneToOne
    @JoinColumn(name = "account_id")
    Account account;

}
