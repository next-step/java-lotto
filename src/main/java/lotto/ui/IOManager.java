package lotto.ui;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningLottoDto;

import static java.util.stream.Collectors.toList;

public class IOManager {

    private static final IOManager STANDARD_IO_MANAGER = new IOManager(new StandardInput(),
                                                                       new StandardOutput());

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
        output.printLine("구입금액을 입력해주세요.");
        return input.nextInt();
    }

    public List<Integer> inputNumbers() {
        output.printLine("지난 주 당첨 번호를 입력해주세요.");
        input.nextLine();
        String data = input.nextLine();
        output.printLine("");

        return Arrays.stream(data.split(","))
                     .map(String::trim)
                     .map(Integer::parseInt)
                     .collect(toList());
    }

    public int inputBonusNumber() {
        output.printLine("보너스 볼을 입력해 주세요.");
        return input.nextInt();
    }

    public void printBuyCount(int count) {
        output.printLine(count + "개를 구매했습니다.");
    }

    public void printLine(String text) {
        output.printLine(text);
    }

    public void printStatistics(LottoStatistics lottoStatistics, int lottoCount) {
        output.printLine("당첨 통계");
        output.printLine("---------");
        printStatisticsDto(lottoStatistics.getStatisticsData());
        printEarningRate(lottoStatistics.getEarningsRate(lottoCount));
    }

    private void printStatisticsDto(List<WinningLottoDto> statistics) {
        statistics.forEach(dto -> output.printLine(type(dto)));
    }

    private String type(WinningLottoDto dto) {

        String bonusMatched = "";

        if (dto.isSecond()) {
            bonusMatched = ", 보너스 볼 일치";
        }

        return dto.getMatchCount() + "개 일치" + bonusMatched + "(" +
            String.format("%,d", dto.getPrize()) + "원)- " +
            dto.getWinningCount() + "개";
    }

    public void printEarningRate(double rate) {
        output.printLine(String.format("총 수익률은 %.2f입니다.", rate));
    }
}
