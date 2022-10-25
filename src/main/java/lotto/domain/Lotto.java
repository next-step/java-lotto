package lotto.domain;

import lotto.domain.prize.Prize;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final int PRICE = 1000;
    private static final int LOTTO_NUMBER = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(int money) {
        lottoNumbers = addLottoNumbers(new ArrayList<>(), money);
    }

    public Prize prize(LottoNumber winningNumber) {
        return new Prize(lottoNumbers, winningNumber, getSize() * PRICE);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private List<LottoNumber> addLottoNumbers(List<LottoNumber> lottoNumbers, int money) {
        for (int i = 0; i < money / PRICE; i++) {
            lottoNumbers.add(generateLottoNumber());
        }
        return lottoNumbers;
    }

    private LottoNumber generateLottoNumber() {
        return new LottoNumber(LOTTO_NUMBER, new RandomNumberGenerator(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
    }

    private int getSize() {
        return lottoNumbers.size();
    }
}
