package step2.controller;

import step2.domain.LottoMachine;
import step2.domain.LottoNumber;
import step2.domain.Lottos;
import step2.dto.LottoStatisticsDto;
import step2.dto.LottosDto;
import step2.util.StringParser;
import step2.view.LottoView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoView lottoView;
    private final LottoMachine lottoMachine;

    public LottoController() {
        this.lottoView = new LottoView();
        this.lottoMachine = new LottoMachine();
    }

    public void lottoInfoPrint(Lottos lottos) {
        LottosDto lottosDto = createLottosDto(lottos);
        lottoView.lottoInfoPirnt(lottosDto);
    }

    public int paymentMoney() {
        return lottoView.paymentMoney();
    }

    public List<String> manualLottos() {
        return lottoView.manualLottoCount();
    }

    public Lottos createLotto(int money, List<String> manualLottoList) {
        return lottoMachine.createLotto(money, manualLottoList);
    }

    private LottoStatisticsDto createStatisticsDto(Map<Integer, Long> rank, double statistics) {
        return new LottoStatisticsDto(rank, statistics);
    }

    public LottoNumber inputBonusInput() {
        return LottoNumber.of(lottoView.inputBonusInput());
    }

    public void finishView() {
        Map<Integer, Long> statistics = lottoMachine.statistics(inputWinNumber(), inputBonusInput());
        lottoView.finish(createStatisticsDto(statistics, lottoMachine.calculateProfitRate()));
    }

    public List<LottoNumber> inputWinNumber() {
        String stringWinNumbers = lottoView.inputWinNumber();
        return StringParser.toLottoNumberList(stringWinNumbers);
    }

    public LottosDto createLottosDto(Lottos lotto) {
        return new LottosDto(lotto);
    }

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        int money = lottoController.paymentMoney();
        List<String> manualLottoList = lottoController.manualLottos();
        Lottos lottos = lottoController.createLotto(money, manualLottoList);
        lottoController.lottoInfoPrint(lottos);
        lottoController.finishView();
    }
}
