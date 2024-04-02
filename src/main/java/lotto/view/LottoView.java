package lotto.view;

import static java.text.MessageFormat.format;
import static lotto.domain.reward.LottoRank.NONE;
import static lotto.domain.reward.LottoRank.SECOND;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lotto.domain.Lotto;
import lotto.domain.reward.LottoRank;
import lotto.domain.reward.LottoResult;
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
            throw new IllegalArgumentException("총 로또 구매 가격은 정수형으로 입력해야 합니다. 입력: " + userInput);
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
        final Matcher matcher = LOTTO_WINNING_NUMBERS_PATTERN.matcher(userInput);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력하신 로또 당첨 번호가 형식에 맞지 않습니다. 입력: " + userInput);
        }
    }

    public void printLottoPurchaseHistory(final List<Lotto> lottos) {
        output.printLine(format("{0}개를 구매했습니다.", lottos.size()));
        lottos.forEach(this::printLottoNumbers);
    }

    private void printLottoNumbers(final Lotto lotto) {
        final List<Integer> numbers = lotto.extractLottoNumbers();
        numbers.sort(Comparator.naturalOrder());
        output.printLine(numbers.toString());
    }

    public void printLottoWinningResult(final LottoResult lottoResult) {
        output.printLine("\n당첨 통계\n---------");

        final Map<LottoRank, Long> result = lottoResult.result();

        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != NONE)
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> printLottoResultByRank(rank, result));

        output.printLine(format("총 수익률은 {0}입니다. (1보다 크면 이익, 작으면 손해입니다.)", lottoResult.profitRate()));
    }

    private void printLottoResultByRank(final LottoRank rank, final Map<LottoRank, Long> result) {
        final String lottoResultFormat = rank == SECOND ? "{0}개, 보너스 일치 ({1}원) - {2}개" : "{0}개 일치 ({1}원) - {2}개";
        final String lottoResultOutputByRank = format(
                lottoResultFormat,
                rank.matchingCount(),
                rank.rewardAmount(),
                result.getOrDefault(rank, LOTTO_RESULT_DEFAULT_MATCHING_COUNT)
        );

        output.printLine(lottoResultOutputByRank);
    }

    public void printBusinessExceptionMessage(final String message) {
        output.printLine(message);
    }

    public void printUnexpectedExceptionMessage() {
        output.printLine("알 수 없는 예외가 발생했습니다.");
    }
}
