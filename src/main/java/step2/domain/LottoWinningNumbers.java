package step2.domain;

import step2.exception.LottoException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoWinningNumbers {

    private static final String SPLITTER = ",";
    private static final int NUMBER_OF_LOTTO_WINNING_NUMBERS = 6;
    private final List<Integer> lottoWinningNumbers;

    private LottoWinningNumbers(List<Integer> lottoWinningNumbers) {
        validate(lottoWinningNumbers);
        this.lottoWinningNumbers = lottoWinningNumbers;
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

    private void validate(List<Integer> lottoWinningNumbers) {
        if (lottoWinningNumbers.size() != NUMBER_OF_LOTTO_WINNING_NUMBERS) {
            throw new LottoException("당첨 번호는 " + NUMBER_OF_LOTTO_WINNING_NUMBERS + "개여야 합니다.");
        }
    }

    public boolean contain(int number) {
        return lottoWinningNumbers.contains(number);
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
