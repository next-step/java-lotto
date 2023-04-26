package step2.view;

public class OutputView {

    private OutputView() {
        // 생성자 내부 호출 -> 명시적 Exception
        throw new AssertionError();
    }

    public static void outPut(int result) {
        System.out.println(String.format("%d개를 구매하였습니다.", result));
    }
}
