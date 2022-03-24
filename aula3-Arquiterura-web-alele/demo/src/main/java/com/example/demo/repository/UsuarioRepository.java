package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.demo.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository {
    private static String INSERT = "insert into usuario (nome,email,senha) values('?','?','?')";
    private static String SELECT_ALL = "SELECT * FROM usuario";
    @Autowired
    private JdbcTemplate Jdbctemplate;

    public Usuario inser(Usuario usuario) {
        Jdbctemplate.update(INSERT,
                new Object[] { usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha() });
        return usuario;
    }

    public List<Usuario> obterTodos() {
        return Jdbctemplate.query(SELECT_ALL, new RowMapper<Usuario>() {

            @Override
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"));
            }

        });

    }
}
