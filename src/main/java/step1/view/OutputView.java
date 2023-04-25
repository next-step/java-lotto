package step1.view;

import java.util.List;

public class OutputView {

    private OutputView() {
        // 생성자 내부 호출 -> 명시적 Exception
        throw new AssertionError();
    }

    public static void outPut(int result) {
        System.out.println(result);
    }
}
