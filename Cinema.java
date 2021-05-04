package cinema;

import java.util.Scanner;



class Menu {
    public Menu() {
        Transformer cal = new Transformer();
        Seats myCinema = new Seats(cal);
        Scanner in = new Scanner(System.in);
        int com = 0;
        do {
            System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            com = in.nextInt();
            switch (com) {
                case 1:
                    Seats.show(myCinema);
                    break;
                case 2:
                    cal.buyTicket(myCinema);
                    break;
                case 3:
                    cal.statistics();
                    break;
                default:
                    break;
            }
        }while(com != 0);


    }
}

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Menu menu = new Menu();
    }
}