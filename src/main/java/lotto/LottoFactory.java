package lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static final BigDecimal PRICE_PER_LOTTO = BigDecimal.valueOf(1000);
    private static final int PICK_NUMBER = 6;
    private final List<Integer> lottoNumbers;

    public LottoFactory() {
        this.lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(i);
        }
    }

    public List<Lotto> generateLotto(BigDecimal payAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int num = payAmount.divide(PRICE_PER_LOTTO).intValue();

        for (int i = 0; i < num; i++) {
            lottos.add(new Lotto(generateRandomNumbers()));
        }
        return lottos;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> pickNumber = new ArrayList<>();
        Collections.shuffle(lottoNumbers);
        for (int i = 0; i < PICK_NUMBER; i++) {
            pickNumber.add(lottoNumbers.get(i));
        }

        return pickNumber;
    }
}
