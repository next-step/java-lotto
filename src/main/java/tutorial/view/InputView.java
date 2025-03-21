package tutorial.view;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new IllegalStateException("인스턴스를 생성할 수 없는 클래스입니다.");
    }

    public static String inputExpression() {
        System.out.println("계산할 식을 입력해 주세요.");
        return SCANNER.nextLine();
    }
}
