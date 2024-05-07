package com.sbgraphql.sbgraphql.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="address")
public class Address {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
UUID id;
@Column
String primaryAddress;
@ElementCollection
@Column(name="secondaryAddress")
List<String> secondaryAddress;
}
