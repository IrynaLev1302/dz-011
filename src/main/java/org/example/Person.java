package org.example;

public class Person {
        protected String firstName;
        protected String lastName;
        protected int age;
        protected Person partner;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.partner = null;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person getPartner() {
            return partner;
        }

        public void setPartner(Person partner) {
            this.partner = partner;
        }

        public boolean isRetired() {
            // Буде перевизначено в підкласах
            return false;
        }

        public void registerPartnership(Person partner) {
            this.partner = partner;
            partner.setPartner(this);
        }

        public void deregisterPartnership(boolean revertLastName) {
            if (this.partner != null) {
                if (revertLastName && this instanceof Woman) {
                    this.lastName = ((Woman) this).getOriginalLastName();
                }
                this.partner.setPartner(null);
                this.partner = null;
            }
        }
    }

