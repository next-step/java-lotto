package lotto;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.dto.LottosDto;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoApplication {
    public static void main(String[] args) {
        Money money = new Money(inputBuyMoney());
        Lottos lottos = Lottos.lottosMake(money);

        LottosDto lottosDto = new LottosDto(lottos);
        lottoCountMessage(lottosDto);
        lottoTickets(lottosDto);

        WinningNumbers winningNumbers = new WinningNumbers(inputLuckyNumber(), bonusNumber());
        LottoResult lottoResult = new LottoResult(lottos, winningNumbers);
        winningStatics();
        winningResult(lottoResult.matchResult());
        lottoYield(lottoResult.lottoYieldCalculate(money));
    }
}
