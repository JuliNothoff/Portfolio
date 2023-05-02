
package com.JulietaNothoff.Portfolio.security.Service;

import com.JulietaNothoff.Portfolio.security.Entity.Usuario;
import com.JulietaNothoff.Portfolio.security.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author julie
 */

@Service
public class UserDetailsImp implements UserDetailsService{
    
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        
        Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);        
    }
    
}
