package lotto.common;

import java.util.Scanner;

public class ConsoleInputer implements Inputer {
    @Override
    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    @Override
    public int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
