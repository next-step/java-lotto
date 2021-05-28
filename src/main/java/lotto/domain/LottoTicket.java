package lotto.domain;

import lotto.exception.CustomIllegalArgumentException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoTicket {

    private final int INCREMENT_WHEN_MATCH = 1;
    private final int INCREMENT_WHEN_NO_MATCH = 0;
    private final int NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    public LottoTicket(List<Integer> inputs) throws CustomIllegalArgumentException {
        checkNumberCount(inputs);
        checkDuplicated(inputs);
        List<LottoNumber> numbers = new ArrayList<>();
        for (Integer input : inputs) {
            numbers.add(LottoNumber.of(input));
        }
        this.numbers = numbers;
    }

    private void checkDuplicated(List<Integer> numbers) throws CustomIllegalArgumentException {
        HashSet<Integer> collect = new HashSet<>(numbers);
        if (collect.size() < NUMBER_COUNT) {
            throw new CustomIllegalArgumentException(Message.ERROR_LOTTO_NUMBER_DUPLICATED, NUMBER_COUNT);
        }
    }

    private void checkNumberCount(List<Integer> numbers) throws CustomIllegalArgumentException {
        if (numbers.size() != NUMBER_COUNT) {
            throw new CustomIllegalArgumentException(Message.ERROR_LOTTO_NUMBER_WRONG_COUNT, NUMBER_COUNT);
        }
    }

    public Rank rankBasedOn(WinningNumbers winningNumbers) {
        int matchCount = 0;
        for (LottoNumber number : numbers) {
            matchCount += increaseCountWhenMatch(number, winningNumbers);
        }

        return Rank.valueOf(matchCount, winningNumbers.bonusNumberMatches(numbers));
    }

    private int increaseCountWhenMatch(LottoNumber number, WinningNumbers winningNumbers) {
        if (winningNumbers.contains(number)) {
            return INCREMENT_WHEN_MATCH;
        }
        return INCREMENT_WHEN_NO_MATCH;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (LottoNumber lottoNumber : numbers) {
            stringBuilder.append(lottoNumber.number());
            stringBuilder.append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
