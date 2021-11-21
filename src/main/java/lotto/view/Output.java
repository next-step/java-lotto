package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningStatistics;

import java.util.List;
import java.util.stream.Collectors;

public class Output {
    private static final String PURCHASE_MESSAGE = "%s 개를 구매했습니다.\n";
    private static final String LOTTO_NUMBER_ERROR_MESSAGE = "로또 번호를 잘못 입력 했습니다.";
    private static final String WINNING_COUNT_ERROR_MESSAGE = "당첨 번호 개수를 잘못 입력 했습니다.";
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";


    public static void printLottosCount(Lottos lottos) {
        int lottoCount = lottos.lottoCount();
        System.out.printf(PURCHASE_MESSAGE, lottoCount);
    }

    public static void printLottos(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();

        for (Lotto lotto : lottoList) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        String collect = lotto.getNumbers().stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.getNumber()))
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));

        System.out.println(collect);
    }

    public static void LottoNumberError() {
        System.out.println(LOTTO_NUMBER_ERROR_MESSAGE);
    }

    public static void WinningNumberCountError() {
        System.out.println(WINNING_COUNT_ERROR_MESSAGE);
    }

    public static void printWinningStatistics(WinningStatistics statistics) {

    }
}
