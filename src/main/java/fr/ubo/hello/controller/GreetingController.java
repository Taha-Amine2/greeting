package fr.ubo.hello.controller;

import fr.ubo.hello.bean.Greeting;
import fr.ubo.hello.business.GreetingBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Contrôleur REST pour gérer les requêtes liées aux salutations.
 */
@RestController
public class GreetingController {
    private final GreetingBusiness business;

    @Autowired
    public GreetingController(GreetingBusiness business) {
        this.business = business;
    }


    /**
     * Point d'accès pour obtenir une salutation par défaut.
     * @return Objet Greeting avec le message par défaut.
     */
    @RequestMapping(value = "/greeting")
    public Greeting greeting() {
        return business.badGreeting();
    }

    /**
     * Point d'accès pour obtenir une salutation personnalisée.
     * @param name Nom à inclure dans le message de salutation.
     * @return Objet Greeting avec un message personnalisé.
     */
    @RequestMapping(value = "/greeting/{name}")
    public Greeting greeting(@PathVariable("name") String name) {
        return business.greeting(name);
    }

    @RequestMapping(value = "/greeting2")
    public Greeting greeting2(@RequestParam(value = "name", required = false, defaultValue = "world") String name) {
        return business.greeting(name);
    }

    @RequestMapping(value = "/greeting3")
    public Greeting greeting3(@RequestParam(value = "name", required = true) String name) {
        return business.greeting(name);
    }

}
