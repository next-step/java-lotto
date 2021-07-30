package lotto.UI;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;

public class ResultView {

    private static final String COUNTING_MESSAGE = "개를 구매했습니다.";

    public void printLottoCount(List<Lotto> lottos) {
        System.out.println(lottos.size() + COUNTING_MESSAGE);
    }

    public void printLottoNumbers(Lotto lotto) {
        StringBuilder txt = new StringBuilder();

        txt.append("[");
        for(int i = 0; i < lotto.getLottoNumbers().size() - 1; i++) {
            txt.append(lotto.getLottoNumbers().get(i).getLottoNumber()).append(", ");
        }
        txt.append(lotto.getLottoNumbers().get(lotto.getLottoNumbers().size() - 1).getLottoNumber());
        txt.append("]");

        System.out.println(txt);
    }

}
