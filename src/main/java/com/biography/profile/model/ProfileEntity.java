package com.biography.profile.model;

import com.biography.profile.dto.ProfileDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Entity
@Builder
@Table(name = "profile")
@AllArgsConstructor
@NoArgsConstructor
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String biography;

    private String email;

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

