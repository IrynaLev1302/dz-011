package org.example;

import org.example.Man;
import org.example.Person;

public class Woman extends Person {
    private String originalLastName;

    public Woman(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.originalLastName = lastName;
    }

    public String getOriginalLastName() {
        return originalLastName;
    }

    @Override
    public boolean isRetired() {
        return this.age > 60;
    }

    @Override
    public void registerPartnership(Person partner) {
        super.registerPartnership(partner);
        if (partner instanceof Man) {
            this.lastName = partner.getLastName();
        }
    }
}

