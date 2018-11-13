package net.chandol.lotto;

import net.chandol.lotto.domain.*;

import java.util.List;

import static net.chandol.lotto.domain.LottoGame.*;
import static net.chandol.lotto.endpoint.ConsoleUi.*;
import static net.chandol.lotto.util.ConsoleUiUtil.*;

public class Main {
    public static void main(String[] args) {

        Integer inputPrice = getInputNumber("구매금액을 입력해주세요");
        LottoGame lottoGame = new LottoGame(Money.of(inputPrice));

        Integer directCount = getInputNumber("수동으로 구매할 로또 수를 입력해 주세요.");

        List<String> rawLottoNumbers = getInputStringArrays(directCount, "수동으로 구매할 번호를 입력해 주세요.");
        List<LottoNumber> directLottoNumbers = getLottoNumbers(rawLottoNumbers);
        lottoGame.purchase(directLottoNumbers);

        int availableLottoPurchaseCount = lottoGame.getAvailableLottoPurchaseCount();
        List<LottoNumber> autoLottoNumbers = getAutoLottoNumbers(availableLottoPurchaseCount);
        lottoGame.purchase(autoLottoNumbers);

        printLottoPurchaseCount(directLottoNumbers.size(), availableLottoPurchaseCount);
        printLottoNumbers(lottoGame.getLottos());

        String rawWinLottoNumber = getInputString("지난 주 당첨 번호를 입력해 주세요.");
        Integer bonusNumber = getInputNumber("보너스 볼을 입력해 주세요.");

        LottoNumber winLottoNumber = getLottoNumber(rawWinLottoNumber);
        WinningNumber winningNumber = new WinningNumber(winLottoNumber, bonusNumber);

        LottoGameResult lottoGameResult = lottoGame.getLottoGameResult(winningNumber);
        printLottoGameResult(lottoGameResult);
    }
}
