package fr.ubo.hello.business;

import fr.ubo.hello.bean.Greeting;

/**
 * Classe contenant la logique métier pour gérer les salutations.
 */
public class GreetingBusiness {

    /**
     * Retourne une salutation personnalisée avec le paramètre donné.
     * @param name Nom à inclure dans le message de salutation.
     * @return Greeting contenant le message "Hello, [name]!" et un auteur par défaut "system".
     */
    public Greeting greeting(String name) {
        return new Greeting("Hello, " + name + "!", "System");
    }

    /**
     * Retourne une salutation avec un message indiquant que le paramètre est manquant.
     * @return Greeting contenant le message "name est obligatoire. Merci de le renseigner." et un auteur par défaut "system".
     */
    public Greeting badGreeting() {
        return new Greeting("Name est obligatoire. Merci de le renseigner.", "System");
    }
}
