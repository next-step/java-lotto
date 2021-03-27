package step2.view;

import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.Number;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printPurchaseCount(Lottos lottos) {
        System.out.println(String.format("%s개를 구매했습니다.", lottos.getLottos().size()));
    }

    public static void printAllLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(getPrintLottoMessage(lotto));
        }
    }

    private static String getPrintLottoMessage(Lotto lotto) {
        return String.format("%s%s%s", "[", String.join(", ", lottoToStringList(lotto)), "]");
    }

    private static List<String> lottoToStringList(Lotto lotto) {
        return lotto.getNumbers()
                .stream()
                .map(Number::getNumber)
                .map(i -> String.valueOf(i))
                .collect(Collectors.toList());
    }
}
