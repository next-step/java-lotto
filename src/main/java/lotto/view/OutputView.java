package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String NEW_LINE = "\n";
    private static final String DELIMITER = ", ";

    private OutputView() {}

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다." + NEW_LINE, lottos.size());
        for (Lotto lotto : lottos) {
            List<LottoNumber> lottoNumbers = lotto.getNumbers();
            System.out.printf("[%s]" + NEW_LINE, lottoNumbers.stream()
                            .map(LottoNumber::toString)
                    .collect(Collectors.joining(DELIMITER)));
        }
        System.out.println();
    }

}
