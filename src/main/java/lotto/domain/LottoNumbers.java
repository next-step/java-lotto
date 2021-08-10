package lotto.domain;

import lotto.exception.InvalidInputException;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int BOUND = 45;
    private static final int SIZE = 6;
    private static final String INVALID_SIZE_OF_WINNING_NUMBERS = "당첨 번호의 갯수가 올바르지 않습니다.";
    private static final String INVALID_WINNING_NUMBERS = "유효하지 않은 번호를 입력하셨습니다.";

    private List<Integer> allNumbers = new ArrayList<>();
    private Set<Integer> winningNumbers = new HashSet<>();

    public LottoNumbers() {
        for (int i = 1; i <= BOUND; i++) {
            allNumbers.add(i);
        }
    }

    public List<Integer> generateRandomNumbers() {
        Collections.shuffle(allNumbers);
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            randomNumbers.add(allNumbers.get(i));
        }
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    public void setWinningNumbers(String strNumbers) {
        Set<Integer> winningNumbers = Arrays.stream(strNumbers.split(","))
                                            .map(Integer::parseInt)
                                            .collect(Collectors.toSet());
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public Set<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    private void validateWinningNumbers(Set<Integer> winningNumbers) {
        validateSize(winningNumbers);
        validateNumbers(winningNumbers);
    }

    private void validateSize(Set<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new InvalidInputException(INVALID_SIZE_OF_WINNING_NUMBERS);
        }
    }

    private void validateNumbers(Set<Integer> winningNumbers) {
        int notValidateNumberCount = (int) winningNumbers.stream().filter(n -> !this.allNumbers.contains(n)).count();
        if (notValidateNumberCount > 0) {
            throw new InvalidInputException(INVALID_WINNING_NUMBERS);
        }
    }

}
