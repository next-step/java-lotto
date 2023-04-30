package study.lotto.step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoReader {
    private static final int NUMBERS_OF_WINNING = 6;
    private static final int MINIMUM_WINNING_NUMBER = 1;
    private static final int MAXIMUM_WINNING_NUMBER = 45;
    private final List<Integer> winningNumbers;

    public LottoReader(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if(winningNumbers.size() != NUMBERS_OF_WINNING) {
            throw new IllegalArgumentException("당첨 번호 갯수는 " + NUMBERS_OF_WINNING + "개입니다: " + winningNumbers.size());
        }

        winningNumbers.stream()
                .filter(this::isOutOfRange)
                .findAny()
                .ifPresent(outOfRangeNumber -> {
                    throw new IllegalArgumentException("로또 당첨 번호는 " + MINIMUM_WINNING_NUMBER + " 이상 "
                            + MAXIMUM_WINNING_NUMBER + " 이하의 정수입니다: " + outOfRangeNumber);
                });
    }

    private boolean isOutOfRange(int selectedNumber) {
        return selectedNumber < MINIMUM_WINNING_NUMBER || MAXIMUM_WINNING_NUMBER < selectedNumber;
    }

    public LottoResult resultOf(Lotto lotto) {
        return LottoResult.of(numbersOfMatch(lotto.selectedNumbers()));
    }

    public List<LottoResult> resultOf(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::resultOf)
                .collect(Collectors.toList());
    }

    private int numbersOfMatch(List<Integer> selectedNumbers) {
        return selectedNumbers.stream()
                .filter(winningNumbers::contains)
                .mapToInt(selectNumber -> 1)
                .sum();
    }
}
