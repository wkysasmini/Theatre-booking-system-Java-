public class Ticket extends Person {
    int row;
    int seatNumber;
    double price;

    Ticket(Person person, int row, int seatNumber, double price) {

        super(person.getName(), person.getSurName(), person.getEmail());

        this.row = row;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public int getRow() {
        return this.row;
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }

    public double getPrice() {
        return this.price;
    }

    public void print() {
        System.out.println("Name: " + getName());
        System.out.println("Surname: " + getSurName());
        System.out.println("email: " + getEmail());
        System.out.println("Row number: " + row);
        System.out.println("Seat number: " + seatNumber);
        System.out.println("Amount : $" + price);
    }
}