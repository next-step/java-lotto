package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;

import java.util.stream.Collectors;

public class ResultView {
    private static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";

    public void printLottoes(LottoGame lottoGame) {
        System.out.println(String.format(PURCHASE_COUNT_MESSAGE, lottoGame.getLottoCount()));
        lottoGame.getLottoes().stream()
                .forEach(lotto -> System.out.println(prettyString(lotto)));
    }

    private static String prettyString(Lotto lotto) {
        return String.format("%s%s%s", "[",
                lotto.getLotto()
                        .stream()
                        .map(LottoNumber::getNumber)
                        .sorted()
                        .map(i -> String.valueOf(i))
                        .collect(Collectors.joining(", ")),
                "]");
    }
}
