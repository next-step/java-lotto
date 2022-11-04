package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Winning {
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    private static final int WINNING_NUMBER_QUANTITY = 6;
    private static final int FIRST_PLACE = 6;
    private static final int SECOND_PLACE = 5;
    private static final int THIRD_PLACE = 4;
    private static final int FOURTH_PLACE = 3;
    private final List<Integer> list;

    public Winning(LottoCollection collection, String[] winningNumbers) {
        validation(winningNumbers);
        this.list = collection.checkWinningNumber(winningNumbers);
    }

    public List<Integer> getWinningNumberCount() {
        List<Integer> matchingNumbers = new ArrayList<>();

        matchingNumbers.add(getMatchingCount(integer -> integer == FOURTH_PLACE));
        matchingNumbers.add(getMatchingCount(integer -> integer == THIRD_PLACE));
        matchingNumbers.add(getMatchingCount(integer -> integer == SECOND_PLACE));
        matchingNumbers.add(getMatchingCount(integer -> integer == FIRST_PLACE));

        return matchingNumbers;
    }

    public int getMatchingCount(MatchNumber matchNumber) {
        int count = 0;
        for (Integer integer : list) {
            if (matchNumber.isMatch(integer)) {
                count++;
            }
        }
        return count;
    }

    private void validation(String[] winningNumbers) {
        checkLength(winningNumbers);
        checkBounds(winningNumbers);
    }

    private void checkBounds(String[] winningNumbers) {
        for (String winningNumber : winningNumbers) {
            if (isOutOfNumberBounds(winningNumber)) {
                throw new IllegalArgumentException("당첨번호를 확인해주세요");
            }
        }
    }

    private void checkLength(String[] winningNumbers) {
        if (isLessThanNumberQuantity(winningNumbers)) {
            throw new IllegalArgumentException("당첨번호 개수를 확인해주세요");
        }
    }

    private boolean isLessThanNumberQuantity(String[] winningNumbers) {
        return winningNumbers.length != WINNING_NUMBER_QUANTITY;
    }

    private boolean isOutOfNumberBounds(String winningNumber) {
        return Integer.parseInt(winningNumber) > LOTTO_END_NUMBER || Integer.parseInt(winningNumber) < LOTTO_START_NUMBER;
    }
}
