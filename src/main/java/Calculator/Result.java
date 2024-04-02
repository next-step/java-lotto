package Calculator;

import java.util.Scanner;

public class Result {
    private final Scanner sc = new Scanner(System.in);
    public String input() {
        String input = sc.nextLine();
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("잘못된 입력값 입니다");
        return input;
    }
    public void print(int value) {
        System.out.println(value);
    }
}
