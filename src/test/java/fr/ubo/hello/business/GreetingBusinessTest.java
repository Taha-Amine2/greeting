package fr.ubo.hello.business;
import fr.ubo.hello.bean.Greeting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import fr.ubo.hello.business.GreetingBusiness;

import static org.junit.Assert.assertEquals;

public class GreetingBusinessTest {

    private GreetingBusiness greetingBusiness = new GreetingBusiness();

    @Test
    public void testGreetingWithName() {
        String name = "test";

        Greeting expected = new Greeting("Hello, test!", "System");
        Greeting truevalue = greetingBusiness.greeting(name);
        assertEquals("The greeting message should be 'Hello, test'", expected.getMessage(), truevalue.getMessage());
        assertEquals("The sender should be 'System'", expected.getAuteur(), truevalue.getAuteur());
    }

    // Test the isValidName method

    // Test pour vérifier le comportement de la méthode badGreeting
    @Test
    public void testBadGreeting() {
        Greeting expected = new Greeting("Name est obligatoire. Merci de le renseigner.", "System");
        Greeting actual = greetingBusiness.badGreeting();

        // Vérification de l'égalité entre le message attendu et celui retourné par la méthode
        assertEquals("The greeting message should be 'Name est obligatoire. Merci de le renseigner.'", expected.getMessage(), actual.getMessage());
        assertEquals("The sender should be 'System'", expected.getAuteur(), actual.getAuteur());
    }
}
