package stringcalculator.view;

import java.util.Scanner;
import stringcalculator.domain.Line;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    //TODO 처음에 숫자가 아닐경우 터지게
    public Line inputCalculateString() {

        return new Line(scanner.nextLine());
    }
}
