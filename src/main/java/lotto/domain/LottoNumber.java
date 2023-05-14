package lotto.domain;

import static lotto.utils.LottoNumberValidationUtils.isLottoCandidateNumber;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        isLottoCandidateNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
