package com.wipro.javaassignment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserData {

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Id
    @Column
    private String userName;

    @Column
    private String passwordStr;


}
