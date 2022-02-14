package crud.CrudHexagonal.content.persona.application;

import crud.CrudHexagonal.content.persona.domain.Persona;
import crud.CrudHexagonal.content.persona.infrastucture.controller.dto.input.PersonaInputDTO;
import crud.CrudHexagonal.content.persona.infrastucture.repository.jpa.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPersona {

    @Autowired
    PersonaRepositorio personaRepositorio;

    public Persona crearPersona(Persona persona) {

        if (persona.getUsuario() == null)
            throw new RuntimeException("Usuario no puede ser nulo");

        if (persona.getUsuario().length() > 10 || persona.getUsuario().length() < 6)
            throw new RuntimeException("La longitud de usuario debe ser entre 6 y 10 caracteres");

        if (persona.getPassword() == null)
            throw new RuntimeException("Password no puede ser nulo");

        if (persona.getName() == null)
            throw new RuntimeException("Name no puede ser nulo");

        if (persona.getPersonal_email() == null)
            throw new RuntimeException("Personal_email no puede ser nulo");

        if (persona.getCompany_email() == null)
            throw new RuntimeException("Company_email no puede ser nulo");

        if (persona.getCity() == null)
            throw new RuntimeException("City no puede ser nulo");

        if (persona.getActive() == null)
            throw new RuntimeException("Active no puede ser nulo");

        personaRepositorio.save(persona);
        return persona;
    }

    public Persona buscarPorId(int id_persona) throws Exception{
        return personaRepositorio.findById(id_persona).orElseThrow(() -> new Exception("Id no encontrado"));
    }

    public Persona findByUsuario(String usuario) {
        return personaRepositorio.findByUsuario(usuario);
    }

    public List<Persona> devolverPersonas(){
        return personaRepositorio.findAll();
    }

    public void borrarUsuario(int id_persona){
        personaRepositorio.deleteById(id_persona);
    }
    public Persona actualizarPersona(int id_persona, PersonaInputDTO personaInputDTO){
        Persona persona = personaRepositorio.findById(id_persona).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (personaInputDTO.getUsuario() != null)
            persona.setUsuario(personaInputDTO.getUsuario());

        if (personaInputDTO.getPassword() != null)
            persona.setPassword(personaInputDTO.getPassword());

        if (personaInputDTO.getName() != null && personaInputDTO.getName() != "")
            persona.setName(personaInputDTO.getName());

        if (personaInputDTO.getPersonal_email() != null)
            persona.setPersonal_email(persona.getPersonal_email());

        if (personaInputDTO.getCompany_email() != null)
            persona.setCompany_email(persona.getCompany_email());

        if (personaInputDTO.getCity() != null)
            persona.setCity(persona.getCity());

        if (personaInputDTO.getActive() != null)
            persona.setActive(persona.getActive());

        personaRepositorio.save(persona);
        return persona;
    }
}
