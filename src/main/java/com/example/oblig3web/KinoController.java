package com.example.oblig3web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class KinoController {

    @Autowired
    KinoRepository rep;

    @PostMapping("/lagre")
    public void lagreBillett(Kino innBillett){
        rep.lagreBillett(innBillett);
    }

    @GetMapping("/hentAlle")
    public List<Kino> hentAlleBilletter(){
        return rep.hentAlleBilletter();
    }

    @GetMapping("/slettAlle")
    public void slettAlleBilletter(){
        rep.slettAlleBilletter();
    }
}
