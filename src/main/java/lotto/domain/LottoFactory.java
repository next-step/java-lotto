package lotto.domain;

import java.util.*;

public class LottoFactory {

    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_PRICE = 1000;


    public static List<Lotto> issueLottos(int purchaseAmount) {

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < calculateLottoCount(purchaseAmount); i++) {
            lottos.add(issueLotto());
        }

        return lottos;
    }

    private static int calculateLottoCount(int purchaseAmount) {

        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("음수는 허용하지 않습니다.");
        }

        return purchaseAmount / LOTTO_PRICE;
    }

    private static Lotto issueLotto() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        List<Integer> lotto = new ArrayList<>(numbers.subList(0, LOTTO_SIZE));

        Collections.sort(lotto);

        return new Lotto(new LinkedHashSet<>(lotto));
    }
}
