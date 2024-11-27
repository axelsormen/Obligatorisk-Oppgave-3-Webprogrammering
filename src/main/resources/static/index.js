function kjopBillett() {
    const kjop = {
        film: $("#film").val(),
        antall: $("#antall").val(),
        fornavn: $("#fornavn").val(),
        etternavn: $("#etternavn").val(),
        telefonnr: $("#telefonnr").val(),
        epost: $("#epost").val()
    };

    if (kjop.film === null) {
        $("#utFilm").html("Vennligst velg en film");
        $("#utFilm").css('color', 'red');
    }

    else if (kjop.antall == "" || isNaN(kjop.antall) || kjop.antall < 1) {
        $("#utAntall").html("Vennligst skriv inn et positivt heltall i antall");
        $("#utAntall").css('color', 'red');
        $("#utFilm").html("");
    }

    else if (kjop.fornavn == "") {
        $("#utFornavn").html("Vennligst skriv noe inn i fornavn");
        $("#utFornavn").css('color', 'red');
        $("#utAntall").html("");
    }

    else if (kjop.etternavn == "") {
        $("#utEtternavn").html("Vennligst skriv noe inn i etternavn");
        $("#utEtternavn").css('color', 'red');
        $("#utFornavn").html("");
    }

    else if (kjop.telefonnr == "" || isNaN(kjop.telefonnr) || kjop.telefonnr < 10000000 || kjop.telefonnr > 100000000) {
        $("#utTelefonnr").html("Vennligst skriv inn et telefonnr i telefonnr");
        $("#utTelefonnr").css('color', 'red');
        $("#utEtternavn").html("");
    }

    else if (kjop.epost == "") {
        $("#utEpost").html("Vennligst skriv noe inn i epost");
        $("#utEpost").css('color', 'red');
        $("#utTelefonnr").html("");
    }

    else {
        $.post("/lagre", kjop, function () {
            hentAlle();
        });

        $("#film").val("");
        $("#antall").val("");
        $("#fornavn").val("");
        $("#etternavn").val("");
        $("#telefonnr").val("");
        $("#epost").val("");

        $("#utFilm").html("");
        $("#utAntall").html("");
        $("#utFornavn").html("");
        $("#utEtternavn").html("");
        $("#utTelefonnr").html("");
        $("#utEpost").html("");
    }
}

function hentAlle() {
    $.get( "/hentAlle", function( data ) {
        formaterData(data);
    });
}

function formaterData(billetter){
    let ut = "<table class='table table-striped'><tr><th>Film</th><th>Antall</th><th>Fornavn</th><th>Etternavn</th><th>Telefonnr</th><th>Epost</th></tr>";
    for (const billett of billetter){
        ut+="<tr><td>"+billett.film+"</td><td>"+billett.antall+"</td><td>"+billett.fornavn+"</td><td>"+billett.etternavn+"</td><td>"+billett.telefonnr+"</td><td>"+billett.epost+"</td></tr>";
    }
    ut+="</table>";
    $("#utMelding").html(ut);
}

function slettBillett() {
    $.get("/slettAlle", function() {
        hentAlle();
    });
}
