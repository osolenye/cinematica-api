package com.example.minitinder.models;

import com.example.minitinder.models.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    OrderStatus status;
    String comment;

    @ManyToOne
    @JoinColumn(name = "master_id")
    Person master;
    @ManyToOne
    @JoinColumn(name = "slave_id")
    Person slave;

    Date addDate;

}
