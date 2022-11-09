package lotto;

import lotto.domain.*;
import lotto.dto.LottosDto;

import static lotto.view.InputView.inputLuckyNumber;
import static lotto.view.ResultView.lottoYield;
import static lotto.view.ResultView.winningStatics;
import static lotto.view.ResultView.winningResult;
import static lotto.view.ResultView.lottoTickets;
import static lotto.view.ResultView.lottoCountMessage;

public class LottoController {

    public void lottoStart(int money){
        lottoCountMessage(money);
        Lottos lottos = Lottos.lottosMake(money);
        LottosDto lottosDto = new LottosDto(lottos);
        lottoTickets(lottosDto);
        WinningNumbers winningNumbers =  new WinningNumbers(inputLuckyNumber());
        winningStatics();
        LottoResult lottoResult = new LottoResult(lottos,winningNumbers);
        winningResult(lottoResult.matchResult());
        lottoYield(lottoResult.lottoYieldCalculate(money));
    }
}
