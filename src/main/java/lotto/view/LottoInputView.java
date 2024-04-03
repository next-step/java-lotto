package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.view.io.Input;
import lotto.view.io.Output;

public class LottoInputView {

    private static final int MINIMUM_MANUAL_LOTTO_COUNT = 0;
    private static final String LOTTO_NUMBERS_DELIMITER = ", ";
    private static final Pattern lottoNumbersPattern = Pattern.compile("^(\\d+,\\s)*\\d+$");

    private final Input input;
    private final Output output;

    public LottoInputView(final Input input, final Output output) {
        this.input = input;
        this.output = output;
    }

    public int readLottoTotalPrice() {
        output.printLine("구매 금액을 입력해 주세요.");

        return readInteger();
    }

    public int readManualLottoCount() {
        output.printLine("\n수동으로 구매할 로또 수를 입력해 주세요.");

        return readInteger();
    }

    public int readLottoBonusNumber() {
        output.printLine("보너스 번호를 입력해 주세요.");

        return readInteger();
    }

    private int readInteger() {
        final String userInput = input.readLine();

        try {
            return Integer.parseInt(userInput);

        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("입력이 정수 형태가 아닙니다. 입력: " + userInput);
        }
    }

    public List<List<Integer>> readLottoManualNumbers(final int manualLottoCount) {
        validateManualLottoCountIsNotLessThanMinimum(manualLottoCount);
        output.printLine("\n수동으로 구매할 번호를 입력해 주세요.");

        return Stream.generate(this::readLottoNumbers)
                .limit(manualLottoCount)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateManualLottoCountIsNotLessThanMinimum(int manualLottoCount) {
        if (manualLottoCount < MINIMUM_MANUAL_LOTTO_COUNT) {
            throw new IllegalArgumentException("수동 구매 개수는 음수일 수 없습니다. 개수: " + manualLottoCount);
        }
    }

    public List<Integer> readLottoWinningNumbers() {
        output.printLine("\n지난 주 당첨 번호를 입력해 주세요.");

        return readLottoNumbers();
    }

    private List<Integer> readLottoNumbers() {
        final String userInput = input.readLine();
        validateWinningNumbersInputIsNotNullOrBlank(userInput);

        final String trimmedUserInput = userInput.trim();
        validateWinningNumbersInputMatchesPattern(trimmedUserInput);

        return Arrays.stream(trimmedUserInput.split(LOTTO_NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateWinningNumbersInputIsNotNullOrBlank(final String userInput) {
        if (userInput == null || userInput.isBlank()) {
            throw new IllegalArgumentException("로또 번호는 null 이거나 빈 값일 수 없습니다. 입력: " + userInput);
        }
    }

    private void validateWinningNumbersInputMatchesPattern(final String userInput) {
        final Matcher matcher = lottoNumbersPattern.matcher(userInput);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력하신 로또 번호가 형식에 맞지 않습니다. 입력: " + userInput);
        }
    }
}
