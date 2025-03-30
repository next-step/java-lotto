package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final List<Integer> NUMBERS = IntStream
            .rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).boxed().collect(Collectors.toList());

    public List<Lotto> generate(int money) {
        validateMoney(money);
        int lottoCount = money / LOTTO_PRICE;

        return IntStream.range(0, lottoCount).mapToObj(i -> generateRandomLotto())
                .collect(Collectors.toList());
    }

    private void validateMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 구입 금액은 최소 1000원 이상이어야 합니다.");
        }

        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    private Lotto generateRandomLotto() {
        List<Integer> numbers = new ArrayList<>(NUMBERS);
        Collections.shuffle(numbers);
        List<Integer> selectedNumbers = numbers.subList(0, LOTTO_SIZE);
        Collections.sort(selectedNumbers);
        return new Lotto(selectedNumbers);
    }
}
