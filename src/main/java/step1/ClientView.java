package step1;

import java.util.Scanner;

public class ClientView {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int result = StringPlusCalculator.stringSplitToSum(scanner.next());

        System.out.println(result);
    }
}
