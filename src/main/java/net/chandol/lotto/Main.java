package net.chandol.lotto;

import net.chandol.lotto.domain.*;
import net.chandol.lotto.endpoint.ConsoleUi;

import java.util.List;

import static net.chandol.lotto.domain.LottoGame.getLottoGameResult;
import static net.chandol.lotto.util.ConsoleUiUtil.getLottoNumber;

public class Main {
    public static void main(String[] args) {
        ConsoleUi console = new ConsoleUi();

        Integer inputPrice = console.getInputNumber("구매금액을 입력해주세요");
        List<Lotto> lottos = LottoGame.buy(inputPrice);

        console.printLottoNumbers(lottos);

        String rawWinLottoNumber = console.getInputString("지난 주 당첨 번호를 입력해 주세요.");
        Integer bonusNumber = console.getInputNumber("보너스 볼을 입력해 주세요.");

        LottoNumber winLottoNumber = getLottoNumber(rawWinLottoNumber);
        WinningNumber winningNumber = new WinningNumber(winLottoNumber, bonusNumber);

        LottoGameResult lottoGameResult = getLottoGameResult(winningNumber, lottos);
        console.printLottoGameResult(lottoGameResult);
    }
}
