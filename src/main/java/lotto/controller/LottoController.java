package lotto.controller;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoGroupFactory;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseLottoGroup;
import lotto.domain.RankingResult;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;
import util.Parser;

public class LottoController {

	public PurchaseLottoGroup purchaseLotto() {
		long purchaseQuantity = calculateLottoQuantity(new Amount(InputView.inputPurchaseAmount()));
		int manualQuantity = Parser.toInt(InputView.inputPurchaseManualQuantity());
		long autoQuantity = purchaseQuantity - manualQuantity;

		PurchaseLottoGroup purchaseLottoGroup = PurchaseLottoGroup.create(
			LottoGroupFactory.createManual(InputView.inputPurchaseManualNumbers(manualQuantity)),
			LottoGroupFactory.createAuto(autoQuantity));

		OutputView.printPurchaseQuantity(manualQuantity, autoQuantity);
		OutputView.printPurchaseLottoGroup(purchaseLottoGroup);
		return purchaseLottoGroup;
	}

	private long calculateLottoQuantity(Amount purchaseAmount) {
		return purchaseAmount.divide(Lotto.LOTTO_PRICE);
	}

	public void ranking(PurchaseLottoGroup purchaseLottoGroup) {
		WinningNumbers winningNumbers = new WinningNumbers(
			Stream.of(InputView.inputWinningNumber().split(WinningNumbers.DELIMITER))
				.map(LottoNumber::from)
				.collect(Collectors.toList()),
			LottoNumber.from(InputView.inputBonusNumber())
		);

		RankingResult rankingResult = new RankingResult(purchaseLottoGroup.ranking(winningNumbers));

		OutputView.printWinningStatistics(rankingResult);
		OutputView.printYield(rankingResult.calculateRoi());
	}
}