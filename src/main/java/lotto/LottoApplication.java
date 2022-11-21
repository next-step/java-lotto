package lotto;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.dto.LottosDto;

import static lotto.view.InputView.inputBuyMoney;
import static lotto.view.InputView.inputLuckyNumber;
import static lotto.view.ResultView.*;

public class LottoApplication {
    public static void main(String[] args) {
        Money money = new Money(inputBuyMoney());
        Lottos lottos = Lottos.lottosMake(money);

        LottosDto lottosDto = new LottosDto(lottos);
        lottoCountMessage(lottosDto);
        lottoTickets(lottosDto);

        WinningNumbers winningNumbers =  WinningNumbers.winningNumbersMake(inputLuckyNumber());
        winningStatics();

        LottoResult lottoResult = new LottoResult(lottos,winningNumbers);
        winningResult(lottoResult.matchResult());
        lottoYield(lottoResult.lottoYieldCalculate(money));
    }
}
