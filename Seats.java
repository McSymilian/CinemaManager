package cinema;

class Seats {
    private char[][] seats;
    final int width;
    final int height;

    public Seats(Transformer tik) {
        this.height = tik.rows;
        this.width = tik.col;
        seats = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                seats[i][j] = 'S';
            }
        }
    }

    public static void show(Seats input) {
        System.out.println("Cinema:");
        for (int i = 0; i <= input.height; i++) {
            for (int j = 0; j <= input.width; j++) {
                if (i == 0 && j == 0) {
                    System.out.print(" ");
                } else if (i == 0) {
                    System.out.print(" " + j);
                } else if (j == 0) {
                    System.out.print(i);
                } else {
                    System.out.print(" " + input.seats[i - 1][j - 1]);
                }
            }
            System.out.print("\n");
        }
    }

    public void takePlace(int a, int b) throws Exception {
        if (seats[a - 1][b - 1] == 'S') {
            seats[a - 1][b - 1] = 'B';
        } else {
            throw new Exception("That ticket has already been purchased!");
        }
    }
}
