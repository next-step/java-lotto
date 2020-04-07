package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoGroup;

import java.util.List;
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
}
