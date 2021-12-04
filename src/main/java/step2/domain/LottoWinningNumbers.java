package step2.domain;

import step2.exception.LottoException;

import java.util.*;
import java.util.stream.Collectors;

public class LottoWinningNumbers {

    private static final String SPLITTER = ", ";
    private static final int NUMBER_OF_LOTTO_WINNING_NUMBERS = 6;

    private final List<Integer> lottoWinningNumbers;

    private LottoWinningNumbers(List<Integer> lottoWinningNumbers) {
        validateNumberOf(lottoWinningNumbers);
        validateDuplicate(lottoWinningNumbers);
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    private void validateNumberOf(List<Integer> lottoWinningNumbers) {
        if (lottoWinningNumbers.size() != NUMBER_OF_LOTTO_WINNING_NUMBERS) {
            throw new LottoException("당첨 번호는 " + NUMBER_OF_LOTTO_WINNING_NUMBERS + "개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> lottoWinningNumbers) {
        Set<Integer> lottoWinningNumberSet = new HashSet<>(lottoWinningNumbers);
        if (lottoWinningNumberSet.size() != NUMBER_OF_LOTTO_WINNING_NUMBERS) {
            throw new LottoException("당첨 번호에는 중복이 있으면 안됩니다");
        }
    }

    public static LottoWinningNumbers from(List<Integer> lottoWinningNumbers) {
        return new LottoWinningNumbers(lottoWinningNumbers);
    }

    public static LottoWinningNumbers from(String lottoWinningNumbers) {
        String[] lottoWinningNumberArray = lottoWinningNumbers.split(SPLITTER);
        List<Integer> lottoWinningNumberList = Arrays.stream(lottoWinningNumberArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new LottoWinningNumbers(lottoWinningNumberList);
    }

    public boolean contain(int number) {
        return lottoWinningNumbers.contains(number);
    }

    public int numberOfMatching(int lottoNumber) {
        if (contain(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWinningNumbers that = (LottoWinningNumbers) o;
        return Objects.equals(lottoWinningNumbers, that.lottoWinningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoWinningNumbers);
    }

}
