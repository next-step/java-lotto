package lotto.view.inputview;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {
    public static final String INVALID_NUMBERS_SIZE_ERR_MSG = "입력된 당첨 번호 숫자의 개수가 유효하지 않습니다.";
    private static final String DELIMITER = ",";

    private final Scanner scanner;

    public ConsoleInputView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int getAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    @Override
    public Set<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbersInput = scanner.next();

        Set<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(DELIMITER))
                .map(Integer::valueOf)
                .collect(Collectors.toCollection(TreeSet::new));

        validate(winningNumbers);

        return winningNumbers;
    }

    private void validate(Set<Integer> winningNumbers) {
        validateNumberSize(winningNumbers);
        winningNumbers.forEach(this::validateNumberRange);
    }

    private void validateNumberSize(Set<Integer> winningNumbers) {
        if (winningNumbers.size() != Lotto.VALID_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBERS_SIZE_ERR_MSG);
        }
    }

    private void validateNumberRange(Integer number) {
        if (number < LottoNumber.VALID_MIN_NUMBER || number > LottoNumber.VALID_MAX_NUMBER) {
            throw new IllegalStateException(LottoNumber.INVALID_NUMBER_RANGE_ERR_MSG);
        }
    }
}
