package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningLottoDto;

import static java.util.stream.Collectors.toList;

public class IOManager {

    private static final IOManager STANDARD_IO_MANAGER = new IOManager(new StandardInput(),
                                                                       new StandardOutput());

    private static final String INPUT_MONEY = "구입금액을 입력해주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해주세요.";
    private static final String INPUT_WINNING_LOTTO = "지난 주 당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String BUY_LOTTO_RESULT_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String WINNING_STATUS = "당첨 통계";
    private static final String DELEMITER = "---------";
    private static final String BONUS_MATCHED = ", 보너스 볼 일치";
    private static final String WINNING_RESULT_FORMAT = "%d개 일치%s(%,d원)- %d개";
    private static final String EARNING_RATE_FORMAT = "총 수익률은 %.2f입니다.";

    private static final String BLANK = "";
    private static final String REGEX_COMMA = ",";

    private final Input input;
    private final Output output;

    public IOManager(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public static IOManager standardIOManager() {
        return STANDARD_IO_MANAGER;
    }

    public int inputMoney() {
        output.printLine(INPUT_MONEY);
        return input.nextInt();
    }

    public int inputManualLottoCount() {
        output.printLine(INPUT_MANUAL_LOTTO_COUNT);
        return input.nextInt();
    }

    public List<List<Integer>> inputManualLottoNumbers(int size) {
        output.printLine(INPUT_MANUAL_LOTTO_NUMBER);
        input.nextLine();
        return Stream.generate(input::nextLine)
                     .limit(size)
                     .map(this::parse)
                     .collect(toList());
    }

    public List<Integer> inputNumbers() {
        output.printLine(INPUT_WINNING_LOTTO);
        String data = input.nextLine();
        output.printLine(BLANK);

        return parse(data);
    }

    private List<Integer> parse(String data) {
        return Arrays.stream(data.split(REGEX_COMMA))
                     .map(String::trim)
                     .map(Integer::parseInt)
                     .collect(toList());
    }

    public int inputBonusNumber() {
        output.printLine(INPUT_BONUS_NUMBER);
        return input.nextInt();
    }

    public void printBuyCount(int manualCount, int autoCount) {
        output.printLine(String.format(BUY_LOTTO_RESULT_FORMAT, manualCount, autoCount));
    }

    public void printLine(String text) {
        output.printLine(text);
    }

    public void printStatistics(LottoStatistics lottoStatistics, int lottoCount) {
        output.printLine(WINNING_STATUS);
        output.printLine(DELEMITER);
        printStatisticsDto(lottoStatistics.getStatisticsData());
        printEarningRate(lottoStatistics.getEarningsRate(lottoCount));
    }

    private void printStatisticsDto(List<WinningLottoDto> statistics) {
        statistics.forEach(dto -> output.printLine(type(dto)));
    }

    private String type(WinningLottoDto dto) {

        String bonusMatched = BLANK;

        if (dto.isSecond()) {
            bonusMatched = BONUS_MATCHED;
        }

        return String.format(WINNING_RESULT_FORMAT, dto.getMatchCount(), bonusMatched,
                             dto.getPrize(), dto.getWinningCount());
    }

    public void printEarningRate(double rate) {
        output.printLine(String.format(EARNING_RATE_FORMAT, rate));
    }
}
