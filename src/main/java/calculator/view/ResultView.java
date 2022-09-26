package calculator.view;

public class ResultView {

    private ResultView() {}

    public static void resultTitlePrint() {

        System.out.println("실행 결과");
    }

    public static void resultPrint(final String result) {

        System.out.printf("최종 계산값은 %s 입니다.", result);
    }
}
