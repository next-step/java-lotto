package step2.controller;

import step2.domain.*;
import step2.dto.LottoStatisticsDto;
import step2.dto.LottosDto;
import step2.view.LottoView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoView lottoView;
    private final LottoMachine lottoMachine;
    private final LottoStatistics lottoStatistics;

    public LottoController() {
        this.lottoView = new LottoView();
        this.lottoMachine = new LottoMachine();
        this.lottoStatistics = new LottoStatistics();
    }

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        int money = lottoController.paymentMoney();
        Lottos lottos = lottoController.createLotto(money);
        lottoController.lottoInfoPrint(lottos);
        LottoStatisticsDto statistics = lottoController.statistics(money);
        lottoController.finishView(statistics);
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

    public LottoStatisticsDto statistics(int money) {
        List<LottoNumber> winNumbers = setWinNumber();
        List<Rank> rank = lottoMachine.getRankOfLottos(winNumbers);
        Map<Integer, List<Rank>> MapOfRanks = lottoStatistics.groupMatchOfLotto(rank);
        BigDecimal statistics = lottoStatistics.statistics(money, rank);
        return createStatisticsDto(MapOfRanks, statistics);
    }

    private LottoStatisticsDto createStatisticsDto(Map<Integer, List<Rank>> rank, BigDecimal statistics) {
        return new LottoStatisticsDto(rank, statistics);
    }

    public void finishView(LottoStatisticsDto lottoStatisticsDto) {
        lottoView.finish(lottoStatisticsDto);
    }

    public List<LottoNumber> setWinNumber() {
        String stringWinNumbers = lottoView.setWinNumber();
        return lottoMachine.toLottoNumberList(stringWinNumbers);

    }


    public LottosDto createLottosDto(Lottos lotto) {
        return new LottosDto(lotto);
    }
}
