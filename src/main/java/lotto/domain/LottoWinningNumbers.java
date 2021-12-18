package lotto.domain;

import lotto.exception.LottoException;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.domain.LottoProperties.NUMBER_OF_LOTTO_WINNING_NUMBERS;

public class LottoWinningNumbers {

    private static final String SPLITTER = ", ";

    private final List<LottoNumber> lottoWinningNumbers;
    private final LottoNumber bonus;

    private LottoWinningNumbers(List<LottoNumber> lottoWinningNumbers, LottoNumber bonus) {
        validateNumberOf(lottoWinningNumbers);
        validateDuplicate(lottoWinningNumbers);
        this.bonus = bonus;
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public static LottoWinningNumbers from(List<Integer> lottoWinningNumbers, int bonus) {
        List<LottoNumber> lottoWinningNumberList = lottoWinningNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        LottoNumber bonusNumber = LottoNumber.from(bonus);

        return new LottoWinningNumbers(lottoWinningNumberList, bonusNumber);
    }

    public static LottoWinningNumbers from(String lottoWinningNumbers, String bonus) {
        String[] lottoWinningNumberArray = lottoWinningNumbers.split(SPLITTER);
        List<LottoNumber> lottoWinningNumberList = Arrays.stream(lottoWinningNumberArray)
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        LottoNumber bonusNumber = LottoNumber.from(bonus);
        return new LottoWinningNumbers(lottoWinningNumberList, bonusNumber);
    }

    private void validateNumberOf(List<LottoNumber> lottoWinningNumbers) {
        if (lottoWinningNumbers.size() != NUMBER_OF_LOTTO_WINNING_NUMBERS) {
            throw new LottoException("당첨 번호는 " + NUMBER_OF_LOTTO_WINNING_NUMBERS + "개여야 합니다.");
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoWinningNumbers) {
        Set<LottoNumber> lottoWinningNumberSet = new HashSet<>(lottoWinningNumbers);
        if (lottoWinningNumberSet.size() != NUMBER_OF_LOTTO_WINNING_NUMBERS) {
            throw new LottoException("당첨 번호에는 중복이 있으면 안됩니다");
        }
    }

    public LottoNumber getBonusNumber() {
        return this.bonus;
    }

    public boolean contain(LottoNumber lottoNumber) {
        return lottoWinningNumbers.contains(lottoNumber);
    }

    public int numberContain(LottoNumber lottoNumber) {
        if (contain(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoWinningNumbers that = (LottoWinningNumbers) o;
        return Objects.equals(lottoWinningNumbers, that.lottoWinningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoWinningNumbers);
    }

}
