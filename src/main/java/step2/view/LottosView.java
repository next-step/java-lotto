package step2.view;

import step2.domain.Lotto;
import step2.domain.LottoNumber;
import step2.domain.Lottos;

import java.util.List;

public class LottosView {

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottoList()) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        for (int i = 0; i < lottoNumbers.size() - 1; i++) {
            stringBuilder.append(lottoNumbers.get(i));
            stringBuilder.append(", ");
        }
        stringBuilder.append(lottoNumbers.get(lottoNumbers.size() - 1));
        stringBuilder.append("]");

        System.out.println(stringBuilder);
    }

}
