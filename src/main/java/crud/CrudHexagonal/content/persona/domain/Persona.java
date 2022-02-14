package crud.CrudHexagonal.content.persona.domain;


import com.sun.istack.NotNull;
import crud.CrudHexagonal.content.persona.infrastucture.controller.dto.input.PersonaInputDTO;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    int id_persona;

    @NotNull
    @Column(name = "usuario")
    String usuario;
    @NotNull
    @Column(name = "password")
    String password;
    @NotNull
    @Column(name = "name")
    String name;
    @NotNull
    @Column(name = "surname")
    String surname;
    @NotNull
    @Column(name = "company_email")
    String company_email;
    @NotNull
    @Column(name = "personal_email")
    String personal_email;
    @NotNull
    @Column(name = "city")
    String city;
    @NotNull
    @Column(name = "active")
    Boolean active;
    @NotNull
    @Column(name = "created_date")
    LocalDateTime created_date;
    @Column(name = "imagen_url")
    String imagen_url;
    @Column(name = "termination_date")
    LocalDateTime termination_date;

    public Persona(PersonaInputDTO personaDTO) {
        setId_persona(personaDTO.getId_persona());
        setUsuario(personaDTO.getUsuario());
        setPassword(personaDTO.getPassword());
        setName(personaDTO.getName());
        setSurname(personaDTO.getSurname());
        setCompany_email(personaDTO.getCompany_email());
        setPersonal_email(personaDTO.getPersonal_email());
        setCity(personaDTO.getCity());
        setActive(personaDTO.getActive());
        setCreated_date(personaDTO.getCreatedDate());
        setImagen_url(personaDTO.getImagen_url());
        setTermination_date(personaDTO.getTerminationDate());
    }

    public Persona(){

        this.created_date = LocalDateTime.now();

    }

}
