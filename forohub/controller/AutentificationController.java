package com.forohub.forohub.controller;

import com.forohub.forohub.infra.security.DatosTokenJWT;
import com.forohub.forohub.infra.security.TokenService;
import com.forohub.forohub.domain.usuario.DatosAutenticacion;
import com.forohub.forohub.domain.usuario.Usuario;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")

public class AutentificationController {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager manager;
    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutenticacion datos){
        var athenticacionToken = new UsernamePasswordAuthenticationToken(datos.usuario(), datos.contrasena());
        var autenticacion = manager.authenticate(athenticacionToken);
        var tokenJWT =tokenService.generarToken((Usuario) autenticacion.getPrincipal());

        return  ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
    }
}