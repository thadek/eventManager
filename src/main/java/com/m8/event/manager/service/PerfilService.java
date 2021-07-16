package com.m8.event.manager.service;

import com.m8.event.manager.entity.Perfil;
import com.m8.event.manager.entity.Usuario;
import com.m8.event.manager.error.ErrorServicio;
import com.m8.event.manager.repository.PerfilRepository;
import com.m8.event.manager.repository.UsuarioRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.mail.MessagingException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    EmailService emailService;

    @Transactional
    public Perfil agregarPerfil(String username, String fotoURL, String email, String nombre,
            String apellido, String tel, LocalDate fechaNac, String descripcion) throws ErrorServicio, MessagingException {

        Usuario usuario = usuarioRepository.findByUsername(username);

        validar(email, nombre, apellido, tel);

        Perfil perfil = new Perfil();

        perfil.setEmail(email);
        perfil.setNombre(nombre);
        perfil.setApellido(apellido);
        perfil.setUsuario(usuario);
        perfil.setTel(tel);
        perfil.setFechaNac(fechaNac);
        perfil.setDescripcion(descripcion);

        perfil.setFotoURL(fotoURL);
        
        String subject = "Creaste tu Perfil en EventManager";
        String text = "Hola " + nombre + ": \n Se ha creado con éxito tu perfil "
                + "en EventManager.";

        emailService.enviarCorreo(email, subject, text);

        return perfilRepository.save(perfil);

    }

    @Transactional
    public void modificar(Integer id, String fotoURL, String email, String nombre, 
            String apellido, String tel, LocalDate fechaNac, String descripcion) 
            throws ErrorServicio {

        validar(email, nombre, apellido, tel);

        Optional<Perfil> respuesta = perfilRepository.findById(id);
        if (respuesta.isPresent()) {

            Perfil perfil = respuesta.get();

            perfil.setEmail(email);
            perfil.setNombre(nombre);
            perfil.setApellido(apellido);
            perfil.setTel(tel);
            perfil.setFechaNac(fechaNac);
            perfil.setDescripcion(descripcion);
            perfil.setFotoURL(fotoURL);

            perfilRepository.save(perfil);
        } else {
            throw new ErrorServicio("No existe un perfil con el Id solicitado");
        }
    }
    
    public List<Perfil> verTodosLosPerfiles (){
        
        return perfilRepository.findAll();
    }
    
    public List<Perfil> verListaDeProfesores (){
        
        return perfilRepository.verListaDeProfesores("PROFESOR");
    }

    public void validar(String email, String nombre, String apellido, String tel) 
            throws ErrorServicio {       
        
        if (email == null || email.isEmpty()) {
            throw new ErrorServicio("El email no puede ser nulo");
        }
        
        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre no puede ser nulo");
        }
        
        if (apellido == null || apellido.isEmpty()) {
            throw new ErrorServicio("El apellido no puede ser nulo");
        }
        
        if (tel == null || tel.isEmpty()) {
            throw new ErrorServicio("El teléfono no puede ser nulo");
        }

    }

    public Perfil obtenerPerfil(Integer idPerfil) throws ErrorServicio {

        //Obtengo el perfil a traves de su id
        try {
            return perfilRepository.findById(idPerfil).get();
        } catch (Exception e) {
            throw new ErrorServicio("No existe el perfil con ese id");
        }

    }

}
