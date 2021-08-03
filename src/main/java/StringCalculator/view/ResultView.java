package StringCalculator.view;

public class ResultView {

    private static final ResultView resultView = new ResultView();

    private ResultView() {
    }

    public void printResult(int result) {

        System.out.println(String.format("연산결과는 '%d' 입니다.", result));
    }


    public static ResultView getInstance() {
        return resultView;
    }
}
