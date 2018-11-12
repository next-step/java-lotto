package lotto.domain;

import java.util.List;

public class LottoNumber {

    private List<Integer> numbers;

    public LottoNumber(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isMatchNumber(final LottoNumber sourceLottoNumber, final int point) {
        return calculatorMatchLottoNumberAfterMatchNumberReturn(sourceLottoNumber) == point;
    }

    private int calculatorMatchLottoNumberAfterMatchNumberReturn(final LottoNumber sourceLottoNumber) {
        int matchLottoPoint = 0;
        for (Integer targetLottoNumber : numbers) {
            matchLottoPoint = lottoNumberLoop(sourceLottoNumber, matchLottoPoint, targetLottoNumber);
        }
        return matchLottoPoint;
    }

    private int lottoNumberLoop(LottoNumber sourceLottoNumber, int matchLottoPoint, Integer targetLottoNumber) {
        for (Integer lottoNumber1 : sourceLottoNumber.getNumbers()) {
            matchLottoPoint = checkLottoNumberSame(matchLottoPoint, targetLottoNumber, lottoNumber1);
        }
        return matchLottoPoint;
    }

    private int checkLottoNumberSame(int matchLottoPoint, Integer targetLottoNumber, Integer lottoNumber1) {
        if (targetLottoNumber.equals(lottoNumber1)) {
            matchLottoPoint++;
        }
        return matchLottoPoint;
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }

}
