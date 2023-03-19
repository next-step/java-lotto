package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class WinnerNumber {

    private List<Integer> winnerNumberList;

    private String[] numberArr;

    private static final int LOTTO_NUMBERS_SIZE = 6;

    public WinnerNumber(String[] numberArr) {
        winnerNumberList = getWinnerNumbers(numberArr);
        validateSize(winnerNumberList);
        validateDuplicate(winnerNumberList);
        validateNumberRange(winnerNumberList);
    }

    public List<Integer> getWinnerNumberList() {
        return winnerNumberList;
    }

    private List<Integer> getWinnerNumbers(String[] numberArr) {
        return Arrays.stream(numberArr)
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }

    private void validateSize(List<Integer> winnerNumberList) {
        if (winnerNumberList.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다");
        }
    }

    private void validateDuplicate(List<Integer> winnerNumberList) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(winnerNumberList);
        if(nonDuplicateNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호들은 중복될 수 없습니다.");
        }
    }
    private void validateNumberRange(List<Integer> winnerNumberList) {
        winnerNumberList.stream()
                .filter(winnerNumber -> (winnerNumber<0 || winnerNumber>45))
                .forEach( winnerNumber -> { throw new IllegalArgumentException("로또 숫자는 0~45 사이의 숫자만 가능합니다.");});
    }

}

