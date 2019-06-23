package lotto.common;

import java.util.Scanner;

public class ConsoleInputer implements Inputer {
    @Override
    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        scanner.close();
        return value;
    }
    
    @Override
    public int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        scanner.close();
        return value;
    }
}
