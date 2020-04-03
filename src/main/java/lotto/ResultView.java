package lotto;

public class ResultView {

    private static ResultView resultView = new ResultView();

    public ResultView() {
    }

    public String purchaseLottoTicketInfo(int manualCount, int automaticCount) {
        return "수동으로 " + manualCount + "장, 자동으로 " + automaticCount + "개를 구매했습니다.";
    }

    public void printResult(String result) {
        System.out.println(result);
    }

    public static ResultView getResultView() {
        return resultView;
    }
}
