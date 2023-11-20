package lotto;

public class ResultView {
    public static void main(String[] args) {
        int payMoney = InputView.inputPayMoney();
        int lottoCount = LottoUtil.returnLottoCount(payMoney);
        System.out.println(lottoCount + "개를 구매했습니다.");
    }
}
