package study.lotto.step2.application;

import study.lotto.step2.domain.Lotto;
import study.lotto.step2.domain.LottoResult;
import study.lotto.step2.domain.LottoResults;
import study.lotto.step2.domain.SoldLottos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoReader {
    private static final int NUMBERS_OF_WINNING = 6;
    private static final int MINIMUM_WINNING_NUMBER = 1;
    private static final int MAXIMUM_WINNING_NUMBER = 45;
    private static final String INTEGER_REGEX = "^\\d+$";
    public static final String COMMA = ",";
    private final List<Integer> winningNumbers;

    public LottoReader(String winningNumbers) {
        this(listOf(winningNumbers));
    }

    public LottoReader(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public LottoResults resultOf(SoldLottos soldLottos) {
        return resultOf(soldLottos.lottos());
    }

    private LottoResults resultOf(List<Lotto> lottos) {
        return new LottoResults(
                lottos.stream()
                        .map(this::resultOf)
                        .collect(Collectors.toList())
        );
    }

    private LottoResult resultOf(Lotto lotto) {
        return LottoResult.of(numbersOfMatch(lotto.selectedNumbers()));
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

    private int numbersOfMatch(List<Integer> selectedNumbers) {
        return selectedNumbers.stream()
                .filter(winningNumbers::contains)
                .mapToInt(selectNumber -> 1)
                .sum();
    }

    private static List<Integer> listOf(String winningNumbers) {
        validateIntegerCsv(winningNumbers);
        return Arrays.stream(winningNumbers.split(COMMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateIntegerCsv(String winningNumbers) {
        Arrays.stream(winningNumbers.split(COMMA))
                .map(String::trim)
                .filter(trimmedWinningNumber -> !trimmedWinningNumber.matches(INTEGER_REGEX))
                .findAny()
                .ifPresent(invalidWinningNumber -> {
                    throw new IllegalArgumentException("당첨 번호는 정수형입니다: " + invalidWinningNumber);
                });
    }
}
