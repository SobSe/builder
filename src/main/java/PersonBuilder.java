public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be less than or equal to zero");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        StringBuilder errors = new StringBuilder();
        if (name == null || name.equals(""))  errors.append("Name not filled");
        if (surname == null || surname .equals("")) errors.append(
                                (errors.isEmpty()) ? "Surname not filled" : ", Surname not filled");
        if (!errors.isEmpty()) throw new IllegalStateException(errors.toString());

        Person person = null;
        if (age == 0 && address == null) {
            person = new Person(name, surname);
        } else if (age == 0) {
            person = new Person(name, surname, address);
        } else if (address == null) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname, age, address);
        }
        return person;
    }
}
