package lotto;

import lotto.domain.*;
import lotto.dto.LottosDto;

import static lotto.view.InputView.inputLuckyNumber;
import static lotto.view.ResultView.*;

public class LottoController {

    public void LottoStart(int money){
        lottoCountMessage(money);
        Lottos lottos = Lottos.lottosMake(money);
        LottosDto lottosDto = new LottosDto(lottos);
        lottoTickets(lottosDto);
        WinningNumbers winningNumbers =  new WinningNumbers(inputLuckyNumber());
        winningStatics();
        LottoResult lottoResult = new LottoResult(lottos,winningNumbers);
        winningResult(lottoResult.matchResult());

    }
}
