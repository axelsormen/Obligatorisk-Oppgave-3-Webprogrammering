package com.example.oblig3web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KinoRepository {

    @Autowired
    private JdbcTemplate db;

    public void lagreBillett(Kino innBillett) {
        String sql = "INSERT INTO kino (film,antall,fornavn,etternavn,telefonnr,epost) VALUES(?,?,?,?,?,?)";
        db.update(sql,innBillett.getFilm(),innBillett.getAntall(),innBillett.getFornavn(),innBillett.getEtternavn(),innBillett.getTelefonnr(),innBillett.getEpost());
    }

    public List<Kino> hentAlleBilletter() {
        String sql = "SELECT * FROM kino ORDER BY etternavn";
        List<Kino> alleBilletter = db.query(sql, new BeanPropertyRowMapper(Kino.class));
        return alleBilletter;
    }
    
    public void slettAlleBilletter() {
        String sql = "DELETE FROM kino";
        db.update(sql);
    }
}