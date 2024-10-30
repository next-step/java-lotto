package lotto.domain;

import java.util.*;

public class LottoFactory {

    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_PRICE = 1000;
    private static final String LOTTO_AMOUNT_PATTERN = "^[1-9]\\d+\\s*원";
    private static final String NON_DIGIT_REGEX = "[^0-9]";


    public static List<Lotto> issueLottos(String purchaseAmount) {

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < calculateLottoCount(purchaseAmount); i++) {
            lottos.add(issueLotto());
        }

        return lottos;
    }

    private static int calculateLottoCount(String purchaseAmount) {
        if (!purchaseAmount.trim().matches(LOTTO_AMOUNT_PATTERN)) {
            throw new IllegalArgumentException("올바른 형식의 금액을 입력해주세요!");
        }

        String numericAmount = purchaseAmount.replaceAll(NON_DIGIT_REGEX, "");

        return Integer.parseInt(numericAmount) / LOTTO_PRICE;
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
