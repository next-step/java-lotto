package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Lottos;

public class OutputView {
    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println("[" + getLottNumbersString(lotto) + "]");
        }
    }

    private static String getLottNumbersString(Lotto lotto) {
        return lotto.getNumbers().stream()
            .map(LottoNumber::getNumber)
            .map(Object::toString)
            .reduce((accu, curr) -> accu + ", " + curr)
            .get();
    }
}
