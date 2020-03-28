package stringPlusCalculate.View;


public class ResultView {

    private ResultView() {
    }

    public static ResultView init() {
        return new ResultView();
    }

    public void resultPrint(Double result) {
        System.out.println(trimDecimalZeroResult(result));
    }

    private String trimDecimalZeroResult(double result) {
        if ((int) result == result) {
            return String.valueOf((int) result);
        }
        return String.valueOf(result);
    }

}
