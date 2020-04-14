package com.biography.profile;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.biography.profile.dto.ProfileDTO;
import com.biography.profile.factory.ProfileFactory;
import com.biography.profile.model.ProfileEntity;
import com.biography.profile.repository.ProfileRepository;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.springframework.http.ResponseEntity;

public class PerfilStepDefs extends BiographyProfileEntityApplicationTests {

    private final ProfileFactory profileFactory;

    private final ProfileRepository profileRepository;

    private ResponseEntity<ProfileDTO> profileDTOResponse;

    private ProfileEntity profile;

    public PerfilStepDefs(final ProfileFactory profileFactory,
                          final ProfileRepository profileRepository) {
        this.profileFactory = profileFactory;
        this.profileRepository = profileRepository;
    }

    @Dado("^que possua um perfil cadastro$")
    public void quePossuaUmPerfilCadastro() {
        this.profile = profileFactory.createDefault();
        profileRepository.save(profile);
    }

    @Quando("^realizar a busca pelo perfil$")
    public void realizarABuscaPeloPerfil() {
        this.profileDTOResponse = restTemplate.getForEntity("/profile/{id}", ProfileDTO.class, this.profile.getId());
    }

    @Então("^deve retornar o perfil cadastro$")
    public void deveRetornarOPerfilCadastro() {
        final var body = this.profileDTOResponse.getBody();
        assertAll("Assert em perfil response", () -> assertNotNull(body));
    }
}
