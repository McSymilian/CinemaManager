package cinema;

import java.util.Scanner;

class Transformer {

    int rows;
    int col;
    private int numOfTickets;
    private int currentIncome;
    private int totalIncome;
    public Transformer() {
        numOfTickets = 0;
        currentIncome = 0;
        totalIncome = 0;
        Scanner in = new Scanner(System.in);
        String enter1 = "Enter the number of rows:";
        System.out.println(enter1);
        rows = in.nextInt();
        String enter2 = "Enter the number of seats in each row:";
        System.out.println(enter2);
        col = in.nextInt();
       // in.close();
        if (rows * col <= 60) {
            totalIncome = rows * col * 10;
        } else {
            totalIncome = rows / 2 * col  * 10 + col * (rows - rows / 2) * 8;
        }
    }

    public void buyTicket(Seats seats) {
        numOfTickets++;
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter a row number:");
        int row = in.nextInt();
        System.out.println("Enter a seat number in that row:");
        int colm = in.nextInt();
        in.close();
        if (row > rows || colm > col) {
            System.out.println("Wrong input!");
            buyTicket(seats);
        }
        int price;
        if (rows * col <= 60) {
            price = 10;
        } else {
            if (row <= rows / 2) {
                price = 10;
            } else {
                price = 8;
            }
        }
        currentIncome += price;
        try {
            seats.takePlace(row, colm);
            System.out.println("\nTicket price: $" + price);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            buyTicket(seats);
        }

    }

    public void statistics() {
        System.out.println("Number of purchased tickets: " + numOfTickets);
        System.out.format("Percentage: %.2f%%%n" ,(double) numOfTickets / (double) (rows * col) * 100);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }
}
