package calculator.view;

import java.util.*;

public class InputView {

    public String expression() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("계산하고자 하는 수식을 입력해주세요. (ex) 2 + 3 * 4 / 5");
        return scanner.nextLine();
    }
}
