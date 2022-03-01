package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_END_NUM = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int ZERO = 0;
    private static final String MIN_PURCHASE_EXCEPTION_MESSAGE = "최소 1000원이어야 합니다.";
    private static final LottoShop INSTANCE = new LottoShop();
    private static final List<LottoNumber> ALL_LOTTO_NUMBERS;

    static {
        ALL_LOTTO_NUMBERS = IntStream.range(LOTTO_START_NUM, LOTTO_END_NUM)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
    }

    private LottoShop() {
    }

    public static LottoShop getInstance() {
        return INSTANCE;
    }

    public int countPossibleLottoAmount(final Money money) {
        validatePrice(money);
        return money.divideByLottoPrice();
    }

    private void validatePrice(final Money money) {
        if (money.getMoney() < LOTTO_PRICE) {
            throw new IllegalArgumentException(MIN_PURCHASE_EXCEPTION_MESSAGE);
        }
    }

    public Lotto buyManualLotto(final String[] lottoNumbers) {
            return Lotto.from(Arrays.stream(lottoNumbers)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public List<Lotto> buyAutoLottos(final int amount) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int time = ZERO; time < amount; time++) {
            Collections.shuffle(ALL_LOTTO_NUMBERS);
            lottos.add(new Lotto(ALL_LOTTO_NUMBERS.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toList())));
        }
        return lottos;
    }

}
