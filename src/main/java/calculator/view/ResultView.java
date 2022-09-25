package calculator.view;

public class ResultView {

    private ResultView() {}

    public static void resultTitlePrint() {

        System.out.println("실행 결과");
    }

    public static void resultPrint(final int result) {

        System.out.printf("최종 계산값은 %d 입니다.", result);
    }
}
