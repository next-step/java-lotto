package lotto.domain;

import java.util.List;

public class WinningNumber {

    private LottoNumber bonusNumber;
    private List<LottoNumber> numbers;

    private LottoNumbersParser parser = new LottoNumbersParser();

    public WinningNumber(String winningNumberExp, int bonusNumber) {
        parse(winningNumberExp);
        this.bonusNumber = getBonusNumberIfValid(bonusNumber);
    }

    private LottoNumber getBonusNumberIfValid(int bonusNumber) {
        LottoNumber bonus = new LottoNumber(bonusNumber);
        if (numbers.contains(bonus)) throw new InvalidBonusNumberException(bonusNumber);
        return bonus;
    }

    private void parse(String numberString) {
        try {
            this.numbers = parser.parse(numberString);
        } catch (RuntimeException e) {
            throw new InvalidWinningNumberException(numberString, e);
        }
    }

    public long getMatchedWinningNumberCount(Lotto lotto) {
        return lotto.getMatchedNumberCount(winningNumberMatcher());
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.getMatchedNumberCount(bonusNumberMatcher()) == 1;
    }

    private LottoNumberMatcher winningNumberMatcher() {
        return new ListLottoNumberMatcher(numbers);
    }

    private LottoNumberMatcher bonusNumberMatcher() {
        return bonusNumber.getNumberMatcher();
    }
}

class ListLottoNumberMatcher implements LottoNumberMatcher {

    private List<LottoNumber> list;

    public ListLottoNumberMatcher(List<LottoNumber> list) {
        this.list = list;
    }

    @Override
    public boolean match(LottoNumber number) {
        return list.contains(number);
    }
}