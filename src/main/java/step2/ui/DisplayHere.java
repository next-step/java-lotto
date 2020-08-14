package step2.ui;

import step2.domain.PurchaseRequest;
import step2.constants.RateOfReturn;
import step2.domain.ConfirmResults;
import step2.domain.LottoGames;
import step2.ui.output.OutputChannel;

import static com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text.NEW_LINE;
import static step2.constants.MessageConstant.*;

public class DisplayHere {

	private final OutputChannel outputChannel;

	public DisplayHere() {
		this.outputChannel = OutputChannel.getDefaultChannel();
	}

	public void printPurchasedGames(LottoGames lottoGames) {
		outputChannel.printLine(String.format(PURCHASED_N_COUNT, lottoGames.getGameSize()));
		lottoGames.getLottoGames()
				.forEach(lottoGame -> outputChannel.printLine(lottoGame.toString()));
		outputChannel.printLine(NEW_LINE);
	}

	public void printPrizeStatistics(PurchaseRequest purchaseRequest, ConfirmResults confirmResults) {
		outputChannel.printLine(PRIZE_STATISTICS_HEADER);
		outputChannel.printLine(confirmResults.getStatistics());
		outputChannel.printLine(computeRateOfReturn(purchaseRequest, confirmResults));
	}

	private String computeRateOfReturn(PurchaseRequest purchaseRequest, ConfirmResults confirmResults) {
		int prizeRewardSum = confirmResults.getPrizeRewardSum();
		double rateOfReturn = (double) prizeRewardSum / (double) purchaseRequest.getPurchasePrice();
		return String.format(RATE_OF_RETURN_FORMAT, rateOfReturn, RateOfReturn.of(rateOfReturn).getMessage());
	}
}
