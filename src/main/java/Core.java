import operation.Operater;

import java.util.Scanner;

public class Core {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int result = Operater.calculate(input);

        OutPutView.result(result);
    }
}
