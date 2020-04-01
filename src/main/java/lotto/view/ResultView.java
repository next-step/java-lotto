package lotto.view;

import lotto.domain.Lotto;

public class ResultView {
    private static final String PURCHASED_NUM_NOTICE = "%d개를 구매했습니다.\n";
    private static final String LOTTO_NUMBER_FORMAT = "[%s]\n";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    public static void printIssuedLotto(Lotto lotto) {
        StringBuffer stringBuffer = new StringBuffer(String.format(PURCHASED_NUM_NOTICE, lotto.size()));

        stringBuffer.append(lotto.toString(LOTTO_NUMBER_FORMAT, LOTTO_NUMBER_DELIMITER));

        System.out.println(stringBuffer.toString());
    }
}
