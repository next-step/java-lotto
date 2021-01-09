package lotto.domain;

import util.CommonException;
import util.Message;
import util.Splitter;

import java.util.ArrayList;
import java.util.List;

public class LottoWinnerNumber {
    private final List<Number> winnerNumbers = new ArrayList<>();
    private Number bonusNumber;

    public LottoWinnerNumber(String stringWinnerNumbers, int bonusNumber) {
        winnerNumbers.addAll(Splitter.SplitStringNumbers(stringWinnerNumbers));
        this.bonusNumber = overlapCheck(LottoNumber.of(bonusNumber));
    }

    private Number overlapCheck(Number bonusNumber) {
        if(winnerNumbers.contains(bonusNumber)) {
            CommonException.NumberOverlapException(Message.BONUS_NUMBER_OVERLAP_MESSAGE);
        }
        return bonusNumber;
    }

    public boolean validateContainsNumber(Number number) {
        return winnerNumbers.stream()
                .anyMatch(winnerNumber -> number.checkWinnerNumber(number, winnerNumber));
    }

    public int winnerNumberLength() {
        return winnerNumbers.size();
    }

    public boolean checkBonusNumberContains(List<Number> numbers) {
        return numbers.contains(bonusNumber);
    }
}
