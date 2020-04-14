package lotto.domain;

import java.util.*;

public class LottoSeller {

    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> buyLottos(int money) {
        validateMoney(money);

        int lottoCount = money / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(randomGenerateLotto());
        }
        return lottos;
    }

    private static Lotto randomGenerateLotto() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < Lotto.LOTTO_SIZE) {
            lottoNumbers.add(LottoNumber.of(randomNumber()));
        }
        return Lotto.of(lottoNumbers);
    }

    private static int randomNumber() {
        int randomNumber = new Random().nextInt(LottoNumber.MAX_LOTTO_NUMBER);
        return LottoNumber.MIN_LOTTO_NUMBER + randomNumber;
    }

    private static void validateMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("not enough money");
        }
    }
}
