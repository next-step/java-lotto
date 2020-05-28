package lotto.ui;

import lotto.domain.Lotto;

public class ResultView {
    private static final String ANSWER_INSERT_PRICE = "%d개를 구매했습니다.";

    public void printLottoCount(int count) {
        System.out.println(String.format(ANSWER_INSERT_PRICE, count));
    }

    public void printLotto(Lotto lotto) {
        String[] numbers = lotto.getLottoNumberList().stream().map(value -> String.valueOf(value.getNumber())).toArray(String[]::new);
        System.out.println("[" + String.join(", ", numbers) + "]");
    }
}
