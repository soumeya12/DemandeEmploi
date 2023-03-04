package com.groupeisi.DemendeEmploieI.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    private String fullName;
    private String Age;
    private String email;
    private  String address;
    private String telephone;
    private String specialite;
    private String niveauEtude;
    private String experienceProfessionnelle;
    private String password;
}
