import java.util.*;
import java.io.*;
public class Theatre {
    static int[] row1 = new int[12];
    static int[] row2 = new int[16];
    static int[] row3 = new int[20];
    public static ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public static void main(String[] args) {
        for (int i = 0; i < row1.length; i++) {
            row1[i] = 0;
        }
        for (int i = 0; i < row2.length; i++) {
            row2[i] = 0;
        }
        for (int i = 0; i < row3.length; i++) {
            row3[i] = 0;
        }

        System.out.println("\n\n******************************\nWelcome to the New Theatre\n******************************\n");
        boolean running = true;
        while (running) {
            System.out.println("\n\n----------------------------------------------\nPlease select an option:\n1) Buy a ticket\n2) Print seating area\n3) Cancel ticket\n4) List available seats\n5) Save to file\n6) Load from file\n7) Print ticket information and total price\n8) Sort tickets by price\n     0) Quit");
            System.out.println("----------------------------------------------");

            Scanner input = new Scanner(System.in);
            int option;
            try {
                System.out.print("Enter your option: ");
                option = input.nextInt();
            } catch (InputMismatchException othertypes) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            switch (option) {
                case 1:
                    buy_ticket();
                    break;
                case 2:
                    print_seating_area();
                    break;
                case 3:
                    cancel_ticket();
                    break;
                case 4:
                    show_available();
                    break;
                case 5:
                    save();
                    break;
                case 6:
                    load();
                    break;
                case 7:
                    show_tickets_info();
                    break;
                case 8:
                    sort_tickets();
                    break;
                case 0:
                    System.out.println("\nQuit....\n\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again. ");
            }
        }
    }

    private static void buy_ticket() {
        System.out.println("\n\nBuy Ticket\n---------------\n");
        Scanner input = new Scanner(System.in);

        //inputting name, surname, email, price, rownumbers and seat number to create a tickets
        System.out.print("Please enter your name: ");
        String name = input.nextLine();
        System.out.print("Please enter your surname: ");
        String surname = input.nextLine();
        System.out.print("Please enter your email: ");
        String email = input.nextLine();

        System.out.print("Enter the ticket price: ");
        double price = 0d;
        while (true) {
            try {
                price = input.nextDouble();
                break;
            } catch (InputMismatchException othertypes) {
                System.out.print("Invalid input.\nPlease enter a valid price: ");
                input.nextLine(); // discard invalid input
            }
        }

        Person person = new Person(name, surname, email);//object named person

        boolean validrow = false;
        while (! validrow) {
            try {
                System.out.print("\nEnter the row number(1-3) : ");
                int userrow = input.nextInt();

                if ((userrow > 0) && (userrow <= 3)) {
                        //ROW 1
                    if (userrow == 1) {
                        boolean validseat = false;
                        while (! validseat) {
                            System.out.print("Enter the seat number (1-12) : ");
                            int userseat = input.nextInt();
                            int seat = userseat - 1;
                            if ((userseat > 0) && (userseat <= 12)) {
                                if (row1[seat] == 0) {
                                    System.out.println("Seat is available. Seat reserved successfully.");
                                    row1[seat] = 1;
                                    Ticket ticket = new Ticket(person, userrow, userseat, price);//new ticket objects
                                    tickets.add(ticket);//add the ticket to the tickets array lists
                                    validseat = true;
                                } else {
                                    System.out.println("Sorry. Seat is not available.");
                                    validseat=true;
                                }
                            } else {
                                System.out.println("Wrong seat number\n");
                            }
                        }

                        //ROW 2
                    } else if (userrow == 2) {
                        boolean validseat = false;
                        while (! validseat) {
                            System.out.print("Enter the seat number (1-16) : ");
                            int userseat = input.nextInt();
                            int seat = userseat - 1;
                            if ((userseat > 0) && (userseat <= 16)) {
                                if (row2[seat] == 0) {
                                    System.out.println("Seat is available. Seat reserved successfully.");
                                    row2[seat] = 1;
                                    Ticket ticket = new Ticket(person, userrow, userseat, price);//new ticket objects
                                    tickets.add(ticket);//add the ticket to the tickets array lists
                                    validseat = true;
                                } else {
                                    System.out.println("Sorry. Seat is not available.");
                                    validseat = true;
                                }
                            } else {
                                System.out.println("Wrong seat number\n");
                            }
                        }

                        //ROW 3
                    } else {
                        boolean validseat = false;
                        while (! validseat) {
                            System.out.print("Enter the seat number (1-20) : ");
                            int userseat = input.nextInt();
                            int seat = userseat - 1;
                            if ((userseat > 0) && (userseat <= 20)) {
                                if (row3[seat] == 0) {
                                    System.out.println("Seat is available. Seat reserved successfully.");
                                    row3[seat] = 1;
                                    Ticket ticket = new Ticket(person, userrow, userseat, price);//new ticket objects
                                    tickets.add(ticket);//add the ticket to the tickets array lists
                                    validseat = true;
                                } else {
                                    System.out.println("Sorry. Seat is not available.");
                                    validseat=true;
                                }
                            } else {
                                System.out.println("Wrong seat number\n");
                            }
                        }
                    }
                    validrow = true;
                } else {
                    System.out.println("Wrong row number.Please select again.\n");
                }

            } catch (InputMismatchException othertypes) {
                System.out.println("Invalid input.");
                input.nextLine();
                buy_ticket(); // to allow the user to try again
            }
        }
    }

    private static void print_seating_area() {
        System.out.println("\n\nSeating Area\n---------------\n\n    ***********\n    *  STAGE  *\n    ***********");

        //ROW 1
        for (int i = 0; i < row1.length; i++) {
            int seats = row1[i];
            if(i==0){
                System.out.print("    ");
            }
            if (seats == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }if (i == 5) {
                System.out.print(" ");
            }
        }
        System.out.println();

        //ROW 2
        for (int i = 0; i < row2.length; i++) {
            int seats = row2[i];
            if(i==0){
                System.out.print("  ");
            }
            if (seats == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }if (i == 7) {
                System.out.print(" ");
            }
        }
        System.out.println();

        //ROW 3
        for (int i = 0; i < row3.length; i++) {
            int seats = row3[i];
            if (seats == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }if (i == 9) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    private static void cancel_ticket(){
        System.out.println("\n\nTicket Canceling\n---------------\n");
        Scanner input=new Scanner(System.in);
        boolean validrow = false;
        while (! validrow) {
            try {
                System.out.print("\nEnter the row number(1-3) : ");
                int row = input.nextInt();

                if ((row > 0) && (row <= 3)) {

                    //ROW 1
                    if (row == 1) {
                        boolean validseat = false;
                        while (! validseat) {
                            System.out.print("Enter the seat number (1-12) : ");
                            int userseat = input.nextInt();
                            int seat = userseat - 1;
                            if ((userseat > 0) && (userseat <= 12)) {
                                if (row1[seat] == 1) {
                                    System.out.println("Cancellation of reserved seat successful.");
                                    row1[seat] = 0;
                                    for (int i = 0; i < tickets.size(); i++) {    //removing the data from the arraylist
                                        Ticket ticket = tickets.get(i);
                                        if (ticket.getRow() == row && ticket.getSeatNumber() == userseat) {
                                            tickets.remove(i);
                                            break;
                                        }
                                    }
                                    validseat = true;
                                } else {
                                    System.out.println("Sorry.Seat is not reserved.");
                                    validseat = true;
                                }
                            } else {
                                System.out.println("Wrong seat number\n");
                            }
                        }

                        //ROW 2
                    } else if (row == 2) {
                        boolean validseat = false;
                        while (! validseat) {
                            System.out.print("Enter the seat number (1-16) : ");
                            int userseat = input.nextInt();
                            int seat = userseat - 1;
                            if ((userseat > 0) && (userseat <= 16)) {
                                if (row2[seat] == 1) {
                                    System.out.println("Cancellation of reserved seat successful.");
                                    row2[seat] = 0;
                                    for (int i = 0; i < tickets.size(); i++) {    //removing the data from the arraylist
                                        Ticket ticket = tickets.get(i);
                                        if (ticket.getRow() == row && ticket.getSeatNumber() == userseat) {
                                            tickets.remove(i);
                                            break;
                                        }
                                    }
                                    validseat = true;
                                } else {
                                    System.out.println("Sorry.Seat is not reserved.");
                                    validseat = true;
                                }
                            } else {
                                System.out.println("Wrong seat number\n");
                            }
                        }

                        //ROW 3
                    } else {
                        boolean validseat = false;
                        while (! validseat) {
                            System.out.print("Enter the seat number (1-20) : ");
                            int userseat = input.nextInt();
                            int seat = userseat - 1;
                            if ((userseat > 0) && (userseat <= 20)) {
                                if (row3[seat] == 1) {
                                    System.out.println("Cancellation of reserved seat successful.");
                                    row3[seat] = 0;
                                    for (int i = 0; i < tickets.size(); i++) {    //removing the data from the arraylist
                                        Ticket ticket = tickets.get(i);
                                        if (ticket.getRow() == row && ticket.getSeatNumber() == userseat) {
                                            tickets.remove(i);
                                            break;
                                        }
                                    }
                                    validseat = true;
                                } else {
                                    System.out.println("Sorry.Seat is not reserved.");
                                    validseat = true;
                                }
                            } else {
                                System.out.println("Wrong seat number\n");
                            }
                        }
                    }
                    validrow = true;
                } else {
                        System.out.println("Wrong row number");
                    }
            } catch(InputMismatchException othertypes){
                System.out.println("Invalid input.");
                input.nextLine();
                cancel_ticket(); // to allow the user to try again
            }
        }
    }

    private static void show_available() {
        System.out.println("\n\nAvailable Seats\n---------------\n");
        boolean running = true;
        System.out.println();
        while (running) {
            System.out.print("Seats available in row 1: ");
            for (int i = 0; i < row1.length; i++) {
                if (row1[i]==1) {
                    System.out.print("* ");
                } else {
                    System.out.print(i + 1 + " ");
                }
            }
            break;
        }
        System.out.println();
        while (running) {
            System.out.print("Seats available in row 2: ");
            for (int i = 0; i < row2.length; i++) {
                if (row2[i]==1) {
                    System.out.print("* ");
                } else {
                    System.out.print(i + 1 + " ");
                }
            }
            break;
        }
        System.out.println();
        while (running) {
            System.out.print("Seats available in row 3: ");
            for (int i = 0; i < row3.length; i++) {
                if (row3[i]==1) {
                    System.out.print("* ");
                } else {
                    System.out.print(i + 1 + " ");
                }
            }
            break;
        }
        System.out.println();
    }

    private static void save(){
        System.out.println("\n\nSave to File\n---------------\n");
        try {
            FileWriter writer = new FileWriter("W1953132.txt");
            writer.write("The Rows Information\n---------------\n\n");

            //ROW 1
            writer.write("row 1: ");
            for (int i = 0; i < row1.length; i++) {
                writer.write(row1[i] + " ");
            }
            writer.write("\n");

            //ROW 2
            writer.write("row 2: ");
            for (int i = 0; i < row2.length; i++) {
                writer.write(row2[i] + " ");
            }
            writer.write("\n");

            //ROW 3
            writer.write("row 3: ");
            for (int i = 0; i < row3.length; i++) {
                writer.write(row3[i] + " ");
            }
            writer.close();

            System.out.println("Reserved seats saved to the file 'W1953132.txt'");

        } catch (IOException e) {
            System.out.println("An error occurred while saving the reserved seats to the file");
        }

    }

    public static void load(){
        System.out.println("\n\nLoad File\n---------------\n");
        try {
            File file = new File("W1953132.txt");
            boolean file_exists = file.exists();
            if (file_exists) {
                Scanner file_reader = new Scanner(file);
                while (file_reader.hasNextLine()) {
                    String text = file_reader.nextLine();
                    System.out.println(text);
                }
                file_reader.close();
            }
            else {
                System.out.println("File not found...");
            }
        } catch (IOException e) {
            System.out.println("Error while reading the file.");
            e.printStackTrace();
        }
    }

    public static void show_tickets_info(){
        System.out.println("\n\nTicket information\n---------------\n");
        int totalCost = 0;
        for (int i = 0; i < tickets.size(); i++){//printing ticket details saved in the arraylist
            Ticket ticket = tickets.get(i);
            if(ticket != null){
                ticket.print();
                totalCost += ticket.getPrice();//total cost calculation
                System.out.println();
            }
        }
        System.out.println("Total cost of the ticket: $ " + totalCost);
    }
    public static void sort_tickets(){
        int ticketsize = tickets.size();  //Sort tickets by price (ascending order) using bubble sort
        Ticket temp;
        for (int i=0;i<ticketsize-1;i++) {
            for (int j =0;j<ticketsize-i-1;j++) {
                if (tickets.get(j).getPrice() > tickets.get(j + 1).getPrice()) {
                    temp = tickets.get(j);
                    tickets.set(j, tickets.get(j + 1));
                    tickets.set(j + 1, temp);
                }
            }
        }
        System.out.println("");  // Print the sorted tickets information
        System.out.println("\n\nSort tickets by price\n---------------\n");
        for (int i=0;i<ticketsize;i++) {
            Ticket ticket = tickets.get(i);
            if (ticket != null) {
                ticket.print();
                System.out.println();
            }
        }

    }
}
