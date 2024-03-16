package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoMachine {
    private static final int LOTTO_PER_MONEY = 1_000;
    private static final int START_INCLUSIVE = 0;
    private static final int END_EXCLUSIVE = 6;
    public static final LottoPaper EMPTY_LOTTO_PAPER = new LottoPaper(Collections.emptyList());
    private static final List<LottoNumber> LOTTO_NUMBERS;

    static {
        LOTTO_NUMBERS = IntStream.rangeClosed(1, 45)
                .mapToObj(LottoNumber::new)
                .collect(toList());
    }

    private LottoMachine() {
    }

    public static int size() {
        return LOTTO_NUMBERS.size();
    }

    public static LottoPaper purchase(int money) {
        int quantity = calculate(money);
        if (quantity == 0) {
            return EMPTY_LOTTO_PAPER;
        }

        return new LottoPaper(prepare(quantity));
    }

    private static int calculate(int money) {
        return money / LOTTO_PER_MONEY;
    }

    private static List<Lotto> prepare(int quantity) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 1; i <= quantity; i++) {
            result.add(selectRandomLottoNumbers());
        }

        return result;
    }

    private static Lotto selectRandomLottoNumbers() {
        List<LottoNumber> shuffled = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(shuffled);
        return new Lotto(shuffled.subList(START_INCLUSIVE, END_EXCLUSIVE));
    }
}
