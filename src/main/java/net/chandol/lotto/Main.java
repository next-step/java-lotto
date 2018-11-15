package net.chandol.lotto;

import net.chandol.lotto.domain.LottoGame;
import net.chandol.lotto.domain.LottoGameResult;
import net.chandol.lotto.dto.PurchaseRequest;
import net.chandol.lotto.value.WinningNumber;

import static net.chandol.lotto.endpoint.ConsoleUi.*;

public class Main {
    public static void main(String[] args) {
        PurchaseRequest purchaseRequest = inputPurchaseRequest();

        LottoGame lottoGame = new LottoGame(purchaseRequest);

        printLottoNumberAndCount(purchaseRequest, lottoGame);

        WinningNumber winningNumber = inputWinningNumber();

        LottoGameResult lottoGameResult = lottoGame.getLottoGameResult(winningNumber);
        printLottoGameResult(lottoGameResult);
    }
}
