package step1.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String QUESTIONS = "계산할 문자열을 입력하세요.";
    private static final String BLANK = " ";

    public List<String> input() {
        System.out.println(QUESTIONS);
        return Arrays.asList(SCANNER.nextLine().split(BLANK));
    }
}
