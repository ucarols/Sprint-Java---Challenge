package com.mottu.motuswatch.repository;

import com.mottu.motuswatch.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
