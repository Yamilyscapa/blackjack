import java.util.Scanner;

class Main {

  public static Scanner in = new Scanner(System.in);

  public static int card = 0;
  public static int house = 0;

  static int m(int a, int b) {
    int max = a;
    int min = b;

    int range = max - min + 1;
    int rand = (int) (Math.random() * range) + min;

    return rand;
  }

  static Boolean didLoose(int card) {
    if (card >= 21) {
      System.err.println("You loose");
      return false;
    } else {
      return true;
    }
  }

  static boolean proveRes(String res) {
    if ((res.toLowerCase()).equals("y")) {
      return true;
    } else if ((res.toLowerCase()).equals("n")) {
      house = m2("y", house);
      return false;
    } else {
      System.err.println("Invalid response");
      return false;
    }
  }

  static int m2(String res, int card) {
    if (proveRes(res)) {
      int rand = m(10, 1);

      return card += rand;
    } else {
      return card;
    }
  }

  static void game() {
    System.out.println("You have " + card + ", want to continue? (Y/N)");
    System.out.println("house: " + house);
    String response = in.nextLine();
    card = m2(response, card);
    house = m2(response, house);
  }

  public static void main(String[] args) {
    int max = 10;
    int min = 1;

    // Init game
    card = m(max, min);
    house = m(max, min);

    // Init game
    while (card <= 21) {
      if (card > 21) {
        System.out.println("You have " + card + ", You loose!");
        System.exit(0);
      } else if (house > 21) {
        System.out.println("House have " + house + ", You win!");
        System.exit(0);
      }

      if (card == 21) {
        System.out.println("You have " + card + ", You Win!");
        System.exit(0);
      } else {
        game();
      }
    }

    if (house == 21) {
      System.out.println("House has: " + card + ", House wins!");
      System.exit(0);
    }

    System.out.println("You have " + card + ", You Win!");

    in.close();
  }
}
