package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class LottoCreater {

    private static final int LOTTO_AMOUNT = 1000;
    private static final ArrayList<Integer> LOTTO_NUMBER_LIST = Stream.iterate(1, n -> n + 1)
                                                                      .limit(45)
                                                                      .collect(toCollection(ArrayList::new));

    public static Lottos issueLottos(int purchaseAmount) {

        int amountOfLotto = purchaseAmount/LOTTO_AMOUNT;

        return Lottos.create(
                            Stream.generate(() -> Lotto.of(getLottoNumbers()))
                                  .limit(amountOfLotto)
                                  .collect(toCollection(ArrayList::new))
                            );

    }

    public static List<Integer> issueWinningLottoNumbers() {
        return getLottoNumbers();
    }

    public static List<Integer> getLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBER_LIST);
        return LOTTO_NUMBER_LIST.subList(0, 6);
    }
}
