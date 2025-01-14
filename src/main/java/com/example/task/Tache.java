package com.example.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Tache {
    @Id
    private String id;
    @NotBlank
    private String title;
    @NotBlank(message = "La description ne peut pas être vide")
    private String description;
    @NotBlank
    private String status;
}
