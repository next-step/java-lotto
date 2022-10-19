package lottoGame;

import lottoGame.model.InputParameter;
import lottoGame.model.Lottery;
import lottoGame.model.factory.LottoFactory;
import lottoGame.view.InputView;
import lottoGame.view.ResultView;

import java.text.DecimalFormat;
import java.util.EnumMap;

public class LottoGenerator {
    private final InputParameter inputParameter;
    private final LottoFactory lottoFactory;

    private final ResultView resultView;

    private final EnumMap<WinningRanks, Integer> lotteryBoard = new EnumMap<>(WinningRanks.class);

    private final DecimalFormat df = new DecimalFormat("0.00");


    public LottoGenerator(InputParameter inputParameter, LottoFactory lottoFactory, ResultView resultView) {
        this.inputParameter = inputParameter;
        this.lottoFactory = lottoFactory;
        this.resultView = resultView;

    }

    public void start() {
        Lottery lottery = create(inputParameter);
        resultView.printLottery(inputParameter, lottery);
        lottery.putBoard(resultView.inputWinningNumer(), lotteryBoard);
        resultView.printStatistics(lotteryBoard);
        resultView.printYield(getYield(getTotalSum(lotteryBoard), inputParameter.getAmount()));
    }

    private Lottery create(InputParameter inputParameter) {
        Lottery lottery = new Lottery();
        lottery.create(inputParameter.getLotteryNum(), lottoFactory);
        return lottery;
    }

    private Integer getTotalSum(EnumMap<WinningRanks, Integer> winningMap) {
        return winningMap.entrySet()
                .stream()
                .map(winningEntry -> winningEntry.getKey().getWinnings() * winningEntry.getValue())
                .reduce(Integer::sum)
                .orElse(0);
    }

    private String getYield(Integer totalSum, Integer amount) {
        return df.format((double) totalSum / amount);
    }

}
