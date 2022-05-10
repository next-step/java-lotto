package stringCalculator;

import java.util.Scanner;

public class Input {
    private final Scanner sc = new Scanner(System.in);

    public String askInput() {
        System.out.print("식을 입력해 주세요 : ");
        return sc.nextLine();
    }
}
