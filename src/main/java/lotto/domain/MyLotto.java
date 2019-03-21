package lotto.domain;

import lotto.util.LottoBasicNumber;

import java.util.List;

public class MyLotto {
    private static final int NUMBER_COUNT = 6;
    private boolean matchBonus;

    private List<Integer> numbers;

    public MyLotto(List<Integer> numbers) {
        if (isWrongSize(numbers)) {
            throw new RuntimeException();
        }
        this.numbers = numbers;
        this.matchBonus = false;
    }

    //TODO : 입력숫자개수, 숫자범위 확인하도록 추가
    private boolean isWrongSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            return true;
        }
        
        if (!LottoBasicNumber.checkNumberRange(numbers)) {
            return true;
        }

        return false;
    }

    public int matchNumbers(LuckyLotto luckyLotto) {
        int matchCount = 0;
        for (int luckyNumber : luckyLotto.getNumbers()) {
            matchCount = checkLuckyNumber(luckyNumber, matchCount);
        }

        if (matchCount == 5) {
            matchBonus = isMatchBonus(luckyLotto.getBonusNumber());
            return 0;
        }

        return matchCount;
    }

    private int checkLuckyNumber(int luckyNumber, int matchCount) {
        if (numbers.contains(luckyNumber)) {
            matchCount++;
        }
        return matchCount;
    }

    private boolean isMatchBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }


}
