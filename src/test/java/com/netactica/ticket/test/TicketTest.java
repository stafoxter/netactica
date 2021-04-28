package com.netactica.ticket.test;

import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TicketTest {

    @Test
    @Sql({"/sql/paises.sql","/sql/ciudades.sql","/sql/vuelos.sql"})
    void cargaInicial() {
        System.out.println("Carga inicial");
    }
}
