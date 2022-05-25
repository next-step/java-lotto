package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberType;
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

		List<Lotto> manualNumbers = InputView.inputPurchaseManualNumbers(manualQuantity).stream()
			.map(input -> Lotto.createManual(Arrays.stream(input.split(Lotto.SPLIT_DELIMITER))
				.map(LottoNumber::from)
				.collect(Collectors.toSet())))
			.collect(Collectors.toList());

		PurchaseLottoGroup purchaseLottoGroup = PurchaseLottoGroup.create(manualNumbers, autoQuantity);

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
			LottoNumber.of(InputView.inputBonusNumber(), LottoNumberType.BONUS)
		);

		RankingResult rankingResult = new RankingResult(purchaseLottoGroup.ranking(winningNumbers));

		OutputView.printWinningStatistics(rankingResult);
		OutputView.printYield(rankingResult.calculateRoi());
	}
}