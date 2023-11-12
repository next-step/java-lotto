package study.step1.view;

import java.util.Scanner;

import study.step1.domain.dto.Input;

import static study.step1.view.InputParser.parse;

public class InputView {
    public static Input input() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new Input(parse(input));
    }
}
