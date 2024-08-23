package org.example;

import org.example.Man;
import org.example.Woman;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PersonTest {

    @Test
    public void testManRetirement() {
        Man man = new Man("John", "Doe", 66);
        assertTrue(man.isRetired());

        man.setAge(65);
        assertFalse(man.isRetired());
    }

    @Test
    public void testWomanRetirement() {
        Woman woman = new Woman("Jane", "Doe", 61);
        assertTrue(woman.isRetired());

        woman.setAge(60);
        assertFalse(woman.isRetired());
    }

    @Test
    public void testRegisterPartnership() {
        Man man = new Man("John", "Smith", 30);
        Woman woman = new Woman("Jane", "Doe", 25);

        woman.registerPartnership(man);

        assertEquals(man, woman.getPartner());
        assertEquals(woman, man.getPartner());
        assertEquals("Smith", woman.getLastName());
    }

    @Test
    public void testDeregisterPartnershipWithRevert() {
        Man man = new Man("John", "Smith", 30);
        Woman woman = new Woman("Jane", "Doe", 25);

        woman.registerPartnership(man);
        woman.deregisterPartnership(true);

        assertNull(woman.getPartner());
        assertNull(man.getPartner());
        assertEquals("Doe", woman.getLastName());
    }

    @Test
    public void testDeregisterPartnershipWithoutRevert() {
        Man man = new Man("John", "Smith", 30);
        Woman woman = new Woman("Jane", "Doe", 25);

        woman.registerPartnership(man);
        woman.deregisterPartnership(false);

        assertNull(woman.getPartner());
        assertNull(man.getPartner());
        assertEquals("Smith", woman.getLastName());
    }
}


