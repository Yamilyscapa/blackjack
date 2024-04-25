import java.util.Scanner;

class Main {

  public static int card = 0;

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
      System.err.println("Ok!");
      return 0;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int max = 10;
    int min = 1;

    card = m(max, min);
    System.out.println("You have " + card + " want to continue? (Y/N)");
    String response = in.nextLine();

    card = m2(response, card);

    System.out.println(card);

    in.close();
  }
}
