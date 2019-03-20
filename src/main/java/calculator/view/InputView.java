package calculator.view;

import org.apache.commons.lang3.StringEscapeUtils;

import java.util.Scanner;

public class InputView {

    public static String input() {
        Scanner scanner = new Scanner(System.in);
        return StringEscapeUtils.unescapeJava(scanner.nextLine());
    }
}
