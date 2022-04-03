package com.icai.practicas;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.icai.practicas.model.Telefono;
import org.junit.jupiter.api.Test;

public class TelefonoTest {
    
    @Test
    public void testTelefono(){
        Telefono telefono_nacional = new Telefono("679224814");
        Telefono telefono_inter = new Telefono("+447887636992");
        Telefono telefono_false = new Telefono("111122223333444");

        boolean valid_telf_true = telefono_nacional.validar();
        boolean valid_telf_false = telefono_false.validar();
        assertEquals(true, valid_telf_true);
        assertEquals(false, valid_telf_false);
        valid_telf_true = telefono_inter.validar();
        assertEquals(true, valid_telf_true);
    }
}
