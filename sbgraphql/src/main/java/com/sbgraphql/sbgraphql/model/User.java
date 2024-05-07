package com.sbgraphql.sbgraphql.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="address")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
String username;
@OneToOne(cascade = {CascadeType.ALL})
Address address;
@OneToOne(cascade = {CascadeType.ALL})
PhoneNumber phoneNumber;
}
