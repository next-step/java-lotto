package step2.controller;

import step2.domain.*;
import step2.dto.LottoStatisticsDto;
import step2.dto.LottosDto;
import step2.view.LottoView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoView lottoView;
    private final LottoMachine lottoMachine;
    private LottoStatistics lottoStatistics;

    public LottoController() {
        this.lottoView = new LottoView();
        this.lottoMachine = new LottoMachine();
    }

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        int money = lottoController.paymentMoney();
        Lottos lottos = lottoController.createLotto(money);
        lottoController.lottoInfoPrint(lottos);
        lottoController.finishView(money);
    }

    public void lottoInfoPrint(Lottos lottos) {
        LottosDto lottosDto = createLottosDto(lottos);
        lottoView.lottoInfoPirnt(lottosDto);
    }

    public int paymentMoney() {
        return lottoView.paymentMoney();
    }

    public Lottos createLotto(int money) {
        return lottoMachine.createLotto(money);
    }

    private LottoStatisticsDto createStatisticsDto(Map<Integer, List<Rank>> rank, String statistics) {
        return new LottoStatisticsDto(rank, statistics);
    }

    public void finishView(int money) {
        List<Integer> rankOfLottos = lottoMachine.getRankOfLottos(inputWinNumber());
        int bonusNumber = lottoView.inputBonusInput();
        lottoStatistics = new LottoStatistics(money, rankOfLottos);
        Map<Integer, List<Rank>> statistics = lottoStatistics.statistics(rankOfLottos);
        lottoView.finish(createStatisticsDto(statistics, lottoStatistics.getStringEarningRate()));
    }

    public List<LottoNumber> inputWinNumber() {
        String stringWinNumbers = lottoView.inputWinNumber();
        return lottoMachine.toLottoNumberList(stringWinNumbers);
    }

    public LottosDto createLottosDto(Lottos lotto) {
        return new LottosDto(lotto);
    }
}
