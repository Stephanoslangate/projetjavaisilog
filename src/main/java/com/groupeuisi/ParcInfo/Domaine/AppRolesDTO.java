package com.groupeuisi.ParcInfo.Domaine;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppRolesDTO {
    private int id;
    @NotNull(message = "le nom ne doit pas etre null")
    private String nom;
}
