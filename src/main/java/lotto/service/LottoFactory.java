package lotto.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.Calculator;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoFactory {
    private static final int PICK_NUMBER = 6;
    private final List<Integer> lottoNumbers;
    private final Calculator calculator;

    public LottoFactory(Calculator calculator) {
        this.lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(i);
        }
        this.calculator = calculator;
    }

    public Lotto generateLotto(BigDecimal payAmount) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        int num = calculator.calculatePurchasedLottoNum(payAmount);

        for (int i = 0; i < num; i++) {
            lottoNumbers.add(new LottoNumber(generateRandomNumbers()));
        }
        return new Lotto(lottoNumbers);
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
