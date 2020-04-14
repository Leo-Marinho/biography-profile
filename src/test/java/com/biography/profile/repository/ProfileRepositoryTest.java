package com.biography.profile.repository;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.biography.profile.BiographyProfileApplication;
import com.biography.profile.exceptions.NotFoundException;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@DisplayName("Teste de integração com repositorio")
@SpringBootTest(classes = {BiographyProfileApplication.class})
class ProfileRepositoryTest {

    @Autowired
    private ProfileRepository profileRepository;

    @Test
    @DBRider
    @DisplayName("Buscar perfil no repositório por id")
    @DataSet(value = "datasets/profile.yml", cleanBefore = true)
    void shouldFindProfileByid() {

        final var profile = profileRepository.findById(1L).orElseThrow(
                () -> new NotFoundException("Perfil inexistente"));

        assertAll("Asserts da consulta do perfil", () -> assertNull(profile));
    }
}
