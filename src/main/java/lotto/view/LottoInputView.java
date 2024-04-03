package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import lotto.view.io.Input;
import lotto.view.io.Output;

public class LottoInputView {

    private static final String LOTTO_WINNING_NUMBERS_DELIMITER = ", ";
    private static final Pattern winningNumbersPattern = Pattern.compile("^(\\d+,\\s)*\\d+$");

    private final Input input;
    private final Output output;

    public LottoInputView(final Input input, final Output output) {
        this.input = input;
        this.output = output;
    }

    public int readLottoTotalPrice() {
        output.printLine("구매 금액을 입력해 주세요.");
        final String userInput = input.readLine();

        try {
            return Integer.parseInt(userInput);

        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("총 로또 구매 가격은 정수형으로 입력해야 합니다. 입력: " + userInput);
        }
    }

    public List<Integer> readLottoWinningNumbers() {
        output.printLine("\n지난 주 당첨 번호를 입력해 주세요.");

        final String userInput = input.readLine();
        validateWinningNumbersInputIsNotNullOrBlank(userInput);

        final String trimmedUserInput = userInput.trim();
        validateWinningNumbersInputMatchesPattern(trimmedUserInput);

        return Arrays.stream(trimmedUserInput.split(LOTTO_WINNING_NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }

    public int readLottoBonusNumber() {
        output.printLine("보너스 번호를 입력해 주세요.");
        final String userInput = input.readLine();

        try {
            return Integer.parseInt(userInput);

        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 정수형으로 입력해야 합니다. 입력: " + userInput);
        }
    }

    private void validateWinningNumbersInputIsNotNullOrBlank(final String userInput) {
        if (userInput == null || userInput.isBlank()) {
            throw new IllegalArgumentException("로또 당첨 번호는 null 이거나 빈 값으로 입력 할 수 없습니다. 입력: " + userInput);
        }
    }

    private void validateWinningNumbersInputMatchesPattern(final String userInput) {
        final Matcher matcher = winningNumbersPattern.matcher(userInput);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력하신 로또 당첨 번호가 형식에 맞지 않습니다. 입력: " + userInput);
        }
    }
}
