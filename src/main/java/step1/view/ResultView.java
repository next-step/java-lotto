package step1.view;

import step1.domain.Operand;

public class ResultView {

    private ResultView() {

    }

    public static void print(Operand result) {
        System.out.println("연산 결과는 다음과 같습니다.");
        System.out.println(result.getValue());
    }
}
