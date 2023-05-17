package autolotto;

import autolotto.dto.LottoDTO;
import autolotto.dto.Statistics;
import autolotto.dto.WinningAmount;
import autolotto.machine.LottoMachine;
import autolotto.machine.lotto.LottoGenerator;
import autolotto.machine.lotto.RandomShuffler;
import autolotto.machine.winning.Winning;
import autolotto.machine.winning.WinningNumbers;
import autolotto.view.ConsoleView;
import calculator.parser.converter.IntegerStringConverter;

import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        IntegerStringParser parser = new IntegerStringParser(", ", new IntegerStringConverter());

        LottoMachine lottoMachine =
                new LottoMachine(new LottoGenerator(new RandomShuffler()), consoleView.inputPurchaseAmount());

        consoleView.printLottoCount(lottoMachine.lottoCount());
        consoleView.printLottoNumbers(
                lottoMachine.lotteries().stream()
                        .map(LottoDTO::from)
                        .collect(Collectors.toList()));

        WinningNumbers winningNumbers = new WinningNumbers(parser.parse(consoleView.inputWinningNumbers()));

        consoleView.printStatistic(new Statistics(
                lottoMachine.profitRate(winningNumbers).toPlainString(),
                convertToWinningAmount(lottoMachine.winningState(winningNumbers))));
    }

    private static Map<WinningAmount, Integer> convertToWinningAmount(Map<Winning, Integer> lottoCountPerMatchingNumber) {
        return lottoCountPerMatchingNumber.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> new WinningAmount(entry.getKey().matchNumber(), entry.getKey().winningMoney()),
                        Map.Entry::getValue));
    }
}
