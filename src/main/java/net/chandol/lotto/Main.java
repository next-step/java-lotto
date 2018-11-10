package net.chandol.lotto;

import net.chandol.lotto.domain.Lotto;
import net.chandol.lotto.domain.LottoGame;
import net.chandol.lotto.domain.LottoGameResult;
import net.chandol.lotto.domain.LottoNumber;
import net.chandol.lotto.endpoint.ConsoleUi;
import net.chandol.lotto.util.ConsoleUiUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConsoleUi console = new ConsoleUi();

        Integer inputPrice = console.getInputNumber("구매금액을 입력해주세요");
        List<Lotto> lottos = LottoGame.buy(inputPrice);

        console.printLottoNumbers(lottos);

        String rawWinLottoNumber = console.getInputString("지난 주 당첨 번호를 입력해 주세요.");
        LottoNumber winLottoNumber = ConsoleUiUtil.getLottoNumber(rawWinLottoNumber);

        LottoGameResult lottoGameResult = LottoGame.getLottoGameResult(winLottoNumber, lottos);
        console.printLottoGameResult(lottoGameResult);
    }
}
