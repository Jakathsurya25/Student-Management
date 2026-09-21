package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @Min(value = 1, message = "Roll number must be greater than 0")
    private int rno;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Gender cannot be empty")
    private String gender;

    @NotBlank(message = "Technology cannot be empty")
    private String technology;
}