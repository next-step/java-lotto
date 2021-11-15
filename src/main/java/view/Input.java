package view;

import util.InputUtil;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {

    public void input() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        InputUtil.paresNumber(input);
    }
}
