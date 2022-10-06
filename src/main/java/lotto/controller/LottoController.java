package lotto.controller;

import lotto.domain.LottoStatistics;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.dto.LottoRequestDto;
import lotto.dto.WinningLottoDto;
import lotto.view.InputView;
import lotto.view.LottoResult;
import lotto.view.LottoStatisticsResult;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    private final LottoStore lottoStore = new LottoStore();

    public void start() {
        LottoRequestDto request = getLottoRequest();
        Lottos lottos = lottoStore.buy(request);
        ResultView.printLottoResult(new LottoResult(lottos));

        WinningLottoDto winningLotto = getWinningLotto();

        LottoStatistics statistics = lottoStore.createStatistics(lottos, winningLotto);
        ResultView.printLottoStatistics(new LottoStatisticsResult(statistics));
    }

    private static LottoRequestDto getLottoRequest() {
        int money = Integer.parseInt(InputView.inputMoney());
        int lottoQuantity = Integer.parseInt(InputView.inputManualQuantity());
        List<String> manualLottoNumbers = InputView.inputLottoNumber(lottoQuantity);

        return new LottoRequestDto(money, manualLottoNumbers);
    }

    private WinningLottoDto getWinningLotto() {
        String winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = Integer.parseInt(InputView.inputBonusNumber());
        return new WinningLottoDto(winningNumbers, bonusNumber);
    }
}
