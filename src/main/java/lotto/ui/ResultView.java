package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoGroup;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ResultView {
    public static void printLottoGroup(LottoGroup lottoGroup) {
        List<Lotto> lottos = lottoGroup.getLottos();
        System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
        for (Lotto lotto : lottos) {
            String lottoNumbers = lotto.getLottoNumbers().stream()
                    .map(lottoNumber -> String.valueOf(lottoNumber))
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(lottoNumbers);
        }
    }

    public static void printEarningRate(String earningRate) {
        System.out.printf(String.format("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", earningRate));
    }
}
