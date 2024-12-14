package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.shuffle;

public class LottoGenerator {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int ZERO = 0;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static Lottos createLottos(int amount, int manualLottoQuantity, List<String> manualLottos) {
        int quantity = amount / LOTTO_PRICE;
        if (manualLottoQuantity < ZERO || quantity < manualLottoQuantity) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수가 유효하지 않습니다.");
        }

        List<Lotto> lottoList = manualLottos.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());

        int autoLottoQuantity = quantity - manualLottoQuantity;
        for (int i = 0; i < autoLottoQuantity; i++) {
            lottoList.add(new Lotto(createLotto()));
        }

        return new Lottos(lottoList);
    }

    private static List<LottoNumber> createLotto() {
        List<Integer> lottoNumbers = createLottoNumbers();
        return lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static List<Integer> createLottoNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            randomNumbers.add(i);
        }
        shuffle(randomNumbers);
        return randomNumbers.subList(ZERO, LOTTO_SIZE);
    }
}
