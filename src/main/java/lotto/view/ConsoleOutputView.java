package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.Collection;

public class ConsoleOutputView {

    public void printLottos(Lottos lottos) {
        Collection<Lotto> lottoCollection = lottos.collect();

        System.out.println(lottoCollection.size() + "개를 구매했습니다.");
        lottoCollection.forEach(lotto -> System.out.println(lotto.getLottoNumbers()));
        System.out.println();
    }

}
