package lotto.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoFactory {
    private static final int PICK_NUMBER = 6;
    private static final BigDecimal PRICE_PER_LOTTO = BigDecimal.valueOf(1000);

    public LottoFactory() {}

    public Lotto generateLotto(BigDecimal payAmount, List<LottoNumber> manualNumbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>(manualNumbers);
        int num = calculatePurchasedLottoNum(payAmount) - manualNumbers.size();

        for (int i = 0; i < num; i++) {
            lottoNumbers.add(new LottoNumber(generateRandomNumbers()));
        }

        return new Lotto(lottoNumbers);
    }

    private int calculatePurchasedLottoNum(BigDecimal payAmount) {
        return payAmount.divide(PRICE_PER_LOTTO).intValue();
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> lottoNumbers = generateLottoNumbers();
        List<Integer> pickNumber = new ArrayList<>();
        for (int i = 0; i < PICK_NUMBER; i++) {
            pickNumber.add(lottoNumbers.get(i));
        }

        return pickNumber;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = LottoNumber.MIN_LOTTO_NUMBER; i <= LottoNumber.MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.add(i);
        }
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }
}
