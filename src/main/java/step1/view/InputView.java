package step1.view;

import step1.exception.SplitException;
import step1.exception.ValueException;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] inputValues() {
        System.out.println("계산식을 입력하세요. 모든 문자는 공백으로 구별해주세요.");
        String input = scanner.nextLine();

        String[] splitArr = SplitException.split(input);
        ValueException.checkAllOperands(splitArr);
        return splitArr;
    }
}
