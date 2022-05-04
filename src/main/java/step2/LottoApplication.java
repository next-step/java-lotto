package step2;

import step2.domain.*;
import step2.view.InputView;
import step2.view.OutPutView;
import step2.view.dto.GameResultDto;
import step2.view.dto.PurchaseCountDto;
import step2.view.dto.PurchaseListDto;
import step2.view.dto.ReturnRateDto;

public class LottoApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutPutView outPutView = new OutPutView();

        int purchaseAmount = inputView.askPurchaseAmount();
        PurchaseCount purchaseCount = new PurchaseCount(purchaseAmount);
        outPutView.show(new PurchaseCountDto(purchaseCount).toString());

        PurchaseList purchaseList = new PurchaseList(purchaseCount);
        outPutView.show(new PurchaseListDto(purchaseList).toString());

        String winnerInput = inputView.askWinnerInput();
        Winner winner = new Winner(winnerInput);
        inputView.close();

        LottoGame lottoGame = new LottoGame(purchaseList, winner);
        GameResult gameResult = lottoGame.calculateGameResult();

        GameResultDto gameResultDto = new GameResultDto(gameResult);
        ReturnRateDto returnRateDto = new ReturnRateDto(gameResult.calculateReturnRate(purchaseAmount));

        outPutView.showResultLine();
        outPutView.show(gameResultDto.toString());
        outPutView.show(returnRateDto.toString());
        outPutView.showEnd();

    }
}
