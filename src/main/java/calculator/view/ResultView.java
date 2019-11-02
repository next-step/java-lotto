package calculator.view;

public class ResultView {

    private int result;

    public ResultView(int result) {
        this.result = result;
    }

    public void print() {
        System.out.println("결과 : " + result);
    }
}
