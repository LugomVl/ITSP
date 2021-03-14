package ru.lugom.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(
        name = "rooms",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
)
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "light")
    private boolean light;
}
