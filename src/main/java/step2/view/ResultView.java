package step2.view;

import org.apache.commons.lang3.StringUtils;
import step2.domain.Lotto;
import step2.domain.Lottos;

public class ResultView {

    private static final String PURCHASE_MESSAGE = "%s개를 구매했습니다.";
    private static final String LOTTO_NUMBER_MESSAGE = "[%s]";
    private static final String COMMA = ", ";

    public static void printPurchaseMessage(int count) {
        System.out.println(String.format(PURCHASE_MESSAGE, count));
    }

    public static void printLottos(Lottos lottos) {
        lottos.lottos().stream().forEach(ResultView::printLotto);
        System.out.println();
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(String.format(LOTTO_NUMBER_MESSAGE, lottoText(lotto)));
    }

    private static String lottoText(Lotto lotto) {
        return StringUtils.join(lotto.numbers(), COMMA);
    }

}
