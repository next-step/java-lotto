package step2.controller;

import step2.domain.Lotto;
import step2.domain.LottoMachine;
import step2.domain.LottoNumber;
import step2.domain.Lottos;
import step2.dto.LottoStatisticsDto;
import step2.dto.LottosDto;
import step2.util.StringParser;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;
    private final LottoMachine lottoMachine;

    public LottoController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.lottoMachine = new LottoMachine();
    }

    public void lottoInfoPrint(Lottos lottos) {
        LottosDto lottosDto = createLottosDto(lottos);
        outputView.lottoInfoPirnt(lottosDto);
    }

    public int paymentMoney() {
        return inputView.paymentMoney();
    }

    public List<String> manualLottos() {
        return inputView.manualLottoCount();
    }

    public Lottos createLotto(int money, List<String> manualLottoList) {
        return lottoMachine.createLotto(money, manualLottoList);
    }

    private LottoStatisticsDto createStatisticsDto(Map<Integer, Long> rank, double statistics) {
        return new LottoStatisticsDto(rank, statistics);
    }

    public LottoNumber inputBonusInput() {
        return LottoNumber.of(inputView.inputBonusInput());
    }

    public void finishView() {
        Map<Integer, Long> statistics = lottoMachine.statistics(inputWinNumber(), inputBonusInput());
        outputView.finish(createStatisticsDto(statistics, lottoMachine.calculateProfitRate()));
    }

    public Lotto inputWinNumber() {
        String stringWinNumbers = inputView.inputWinNumber();
        return new Lotto(StringParser.toLottoNumberList(stringWinNumbers));
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
