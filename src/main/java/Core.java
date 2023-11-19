import java.util.Scanner;

public class Core {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Operater operater = Operater.defaultOf(input);
        int calculate = operater.calculate();


    }
}
