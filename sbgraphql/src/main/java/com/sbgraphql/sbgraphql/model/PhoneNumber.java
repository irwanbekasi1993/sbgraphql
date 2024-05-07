package com.sbgraphql.sbgraphql.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="phone_number")
public class PhoneNumber {
    @Id
@GeneratedValue(strategy = GenerationType.UUID)
UUID id;
@Column
String primaryPhoneNumber;
@ElementCollection
@Column
List<String> SecondaryPhoneNumbers;
}
