package lotto.view;

public class OutputView {
    private static final String LOTTO_COUNT_MSG = "개를 구매했습니다.";

    public void drawLottoGameCount(Integer lottoCount) {
        System.out.println(lottoCount + LOTTO_COUNT_MSG);
    }
}
