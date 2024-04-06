package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.LottoApplication.LOTTO_COST;

public class LottoFactory {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    public static final List<Integer> ALL_NUMBERS = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    public static Lottos createLottos(int buyingAmount) {
        if (buyingAmount < LOTTO_COST) {
            throw new IllegalArgumentException("구매 금액이 부족합니다.");
        }

        int lottoAmount = buyingAmount / LOTTO_COST;
        return new Lottos(lottoAmount);
    }

}
