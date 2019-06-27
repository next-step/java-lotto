package lotto.common;

import java.util.Scanner;

public class ConsoleInputer implements Inputer {
    private static Scanner scanner = new Scanner(System.in);
    
    @Override
    public String inputString() {
        return scanner.nextLine();
    }
    
    @Override
    public int inputNumber() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}
