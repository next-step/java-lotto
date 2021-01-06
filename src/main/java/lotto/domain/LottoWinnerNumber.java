package lotto.domain;

import util.CommonConstants;
import util.CommonException;
import util.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoWinnerNumber {
    private static final String COMMA = ",";
    private final List<Number> winnerNumbers = new ArrayList<>();
    private Number bonusNumber;

    public LottoWinnerNumber() {
    }

    public LottoWinnerNumber(String winnerNumbers, int bonusNumber) {
        splitStringNumbers(winnerNumbers);
        this.bonusNumber = overlapCheck(LottoNumber.of(bonusNumber));
    }

    private Number overlapCheck(Number bonusNumber) {
        if(winnerNumbers.contains(bonusNumber)) {
            CommonException.NumberOverlapException(Message.BONUS_NUMBER_OVERLAP_MESSAGE);
        }
        return bonusNumber;
    }

    public void splitStringNumbers(String inputPrizeNumbers) {
        String[] numbers = inputPrizeNumbers.trim().split(COMMA);
        validateInputNumber(numbers);
        createWinnerNumbers(numbers);
    }

    private void validateInputNumber(String[] numbers) {
        if(numbers.length != CommonConstants.NUMBER_LENGTH_MAX) {
            CommonException.IllegalArgumentException(Message.NUMBER_LENGTH_EXCESS);
        }
    }

    private void createWinnerNumbers(String[] numbers) {
        Arrays.stream(numbers)
        .mapToInt(Integer::parseInt)
        .forEach(number -> winnerNumbers.add(LottoNumber.of(number)));
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
