package com.biography.profile.model;

import com.biography.profile.dto.ProfileDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "profile")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is invalid")
    @NotEmpty(message = "Name is invalid")
    @NotBlank(message = "Name is invalid")
    @Size(min = 3, max = 70)
    private String name;

    @NotNull(message = "age is invalid")
    @NotBlank(message = "age is invalid")
    @NotEmpty(message = "age is invalid")
    private Integer age;

    @NotBlank(message = "Biography")
    @NotEmpty(message = "Idade Invalida")
    @Size(max = 300)
    private String biography;

    @NotBlank(message = "Biography")
    @NotEmpty(message = "Idade Invalida")
    @Size(max = 150)
    private String email;

    @NotBlank(message = "Biography")
    @NotEmpty(message = "Idade Invalida")
    @Size(max = 15)
    private String contact;

    @CreationTimestamp
    private Date createAt;

    @UpdateTimestamp
    private Date updateAt;

    public ProfileEntity(final String name, final Integer age, final String biography,
                         final String email, final String contact) {
        this.name = name;
        this.age = age;
        this.biography = biography;
        this.email = email;
        this.contact = contact;
    }

    public ProfileEntity merge(final ProfileDTO profileDTO) {
        this.name = profileDTO.getName();
        this.age = profileDTO.getAge();
        this.biography = profileDTO.getBiography();
        this.email = profileDTO.getEmail();

        return this;

    }
}

