package step1.view;

import step1.util.InputUtil;

import java.util.List;
import java.util.Scanner;


public class Input {

    public static List<Integer> input() {
        System.out.println("입력하세요");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return InputUtil.paresNumberList(input);
    }
}
