public class Person {
    String name;
    String surname;
    String email;

    Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getSurName() {
        return this.surname;
    }

    public String getEmail() {
        return this.email;
    }
}