package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static lotto.domain.LottoRuleConfig.*;

public class Lotto {

    private static final int BONUS_NUMBER_LIST_INDEX = 6;
    private static final int START_WINNING_NUMBERS_INDEX = 0;
    private static final int END_WINNING_NUMBERS_INDEX = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        lottoSizeException();
    }

    private void lottoSizeException() {
        overSizeNumber();
        underSizeNumber();
    }

    private void overSizeNumber() {
        if(lottoNumbers.size() > MAX_LOTTO_BALL_COUNT) {
            throw new IllegalArgumentException(OVER_SIZE_NUMBERS);
        }
    }

    private void underSizeNumber() {
        if(lottoNumbers.size() < MAX_LOTTO_BALL_COUNT) {
            throw new IllegalArgumentException(UNDER_SIZE_NUMBERS);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoResult lottoResult(List<Integer> winningNumbers) {
        int winningCount = sameNumberOfCount(winningNumbers);
        if(isMatchUpToBonusNumber(winningNumbers.get(BONUS_NUMBER_LIST_INDEX))) {
            return LottoResult.valueOf(winningCount,true);
        }
        return LottoResult.valueOf(winningCount,false);
    }

    private boolean isMatchUpToBonusNumber(int bonusNumber) {
        return lottoNumbers.stream()
                .anyMatch(e -> e.getLottoNumber() == bonusNumber);
    }

    private int sameNumberOfCount(List<Integer> winningNumbers) {
        List<Integer> ignoreBonusNumber
                = winningNumbers.subList(START_WINNING_NUMBERS_INDEX,END_WINNING_NUMBERS_INDEX);
        return (int)lottoNumbers.stream()
                .mapToInt(i -> numberMatchResult(ignoreBonusNumber,i.getLottoNumber()))
                .filter(i -> i == 1)
                .count();
    }

    private static int numberMatchResult(List<Integer> winningNumbers, int number) {
        return Collections.frequency(winningNumbers,number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
