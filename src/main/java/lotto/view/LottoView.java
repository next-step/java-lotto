package lotto.view;

import static java.text.MessageFormat.format;
import static lotto.config.LottoExceptionMessage.INPUT_TOTAL_PRICE_MUST_FOLLOW_INTEGER_FORMAT;
import static lotto.config.LottoExceptionMessage.INPUT_WINNING_NUMBERS_MUST_EXIST;
import static lotto.config.LottoExceptionMessage.INPUT_WINNING_NUMBERS_MUST_FOLLOW_PATTERN;
import static lotto.config.LottoExceptionMessage.UNEXPECTED_EXCEPTION_MESSAGE;
import static lotto.domain.reward.LottoRank.NONE;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lotto.domain.Lotto;
import lotto.domain.reward.LottoRank;
import lotto.view.io.Input;
import lotto.view.io.Output;

public class LottoView {

    private static final Pattern LOTTO_WINNING_NUMBERS_PATTERN = Pattern.compile("^(\\d+,\\s)*\\d+$");
    private static final String LOTTO_WINNING_NUMBERS_DELIMITER = ", ";
    private static final long LOTTO_RESULT_DEFAULT_MATCHING_COUNT = 0L;

    private final Input input;
    private final Output output;

    public LottoView(final Input input, final Output output) {
        this.input = input;
        this.output = output;
    }

    public int readLottoTotalPrice() {
        output.printLine("구매 금액을 입력해 주세요.");
        final String userInput = input.readLine();

        try {
            return Integer.parseInt(userInput);

        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_TOTAL_PRICE_MUST_FOLLOW_INTEGER_FORMAT.message(userInput));
        }
    }

    public int[] readLottoWinningNumbers() {
        output.printLine("\n지난 주 당첨 번호를 입력해 주세요.");

        final String userInput = input.readLine();
        validateWinningNumbersInputIsNotNullOrBlank(userInput);

        final String trimmedUserInput = userInput.trim();
        validateWinningNumbersInputMatchesPattern(trimmedUserInput);

        return Arrays.stream(trimmedUserInput.split(LOTTO_WINNING_NUMBERS_DELIMITER))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private void validateWinningNumbersInputIsNotNullOrBlank(final String userInput) {
        if (userInput == null || userInput.isBlank()) {
            throw new IllegalArgumentException(INPUT_WINNING_NUMBERS_MUST_EXIST.message(userInput));
        }
    }

    private void validateWinningNumbersInputMatchesPattern(final String userInput) {
        final Matcher matcher = LOTTO_WINNING_NUMBERS_PATTERN.matcher(userInput);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_WINNING_NUMBERS_MUST_FOLLOW_PATTERN.message(userInput));
        }
    }

    public void printLottoPurchaseHistory(final List<Lotto> lottos) {
        output.printLine(format("{0}개를 구매했습니다.", lottos.size()));

        lottos.stream()
                .map(Lotto::extractLottoNumbers)
                .forEach(this::printSortedLottoNumbers);
    }

    private void printSortedLottoNumbers(final List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
        output.printLine(numbers.toString());
    }

    public void printLottoWinningResult(final Map<LottoRank, Long> lottoResult, final double profitRate) {
        output.printLine("\n당첨 통계\n---------");

        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != NONE)
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> printLottoResultByRank(rank, lottoResult));

        output.printLine(format("총 수익률은 {0}입니다. (1보다 크면 이익, 작으면 손해입니다.)", profitRate));
    }

    private void printLottoResultByRank(final LottoRank rank, final Map<LottoRank, Long> lottoResult) {
        final String lottoResultOutputByRank = format(
                "{0}개 일치 ({1}원) - {2}개",
                rank.matchingCount(),
                rank.rewardAmount(),
                lottoResult.getOrDefault(rank, LOTTO_RESULT_DEFAULT_MATCHING_COUNT)
        );

        output.printLine(lottoResultOutputByRank);
    }

    public void printBusinessExceptionMessage(final String message) {
        output.printLine(message);
    }

    public void printUnexpectedExceptionMessage() {
        output.printLine(UNEXPECTED_EXCEPTION_MESSAGE.message());
    }
}
