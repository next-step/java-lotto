package step3.ui;

import step3.constants.PrizeGrade;
import step3.constants.RateOfReturn;
import step3.domain.ConfirmResults;
import step3.domain.LottoGames;
import step3.domain.PurchaseStandBy;
import step3.ui.output.OutputChannel;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

import static step3.constants.MessageConstant.*;

public class DisplayHere {

	private final OutputChannel outputChannel;

	public DisplayHere() {
		this.outputChannel = OutputChannel.getSystemOutChannel();
	}

	public void printPurchasedGames(LottoGames lottoGames) {
		outputChannel.printLine(String.format(PURCHASED_N_COUNT, lottoGames.getGameSize()));
		lottoGames.getLottoGames()
				.forEach(lottoGame -> outputChannel.printLine(lottoGame.toString()));
		outputChannel.printLine(NEW_LINE);
	}

	public void printPrizeStatistics(PurchaseStandBy purchaseStandBy, ConfirmResults confirmResults) {
		outputChannel.printLine(PRIZE_STATISTICS_HEADER);
		outputChannel.printLine(getReportOfStatisticsEachGroup(confirmResults.getGroupedByPrizeGrade()));
		double rateOfReturn = confirmResults.computeRateOfReturn(purchaseStandBy);
		outputChannel.printLine(String.format(RATE_OF_RETURN_FORMAT, rateOfReturn, RateOfReturn.of(rateOfReturn).getMessage()));
	}

	private String getReportOfStatisticsEachGroup(Map<PrizeGrade, Integer> group) {
		return group.entrySet()
				.stream()
				.sorted(Comparator.comparing(entry -> entry.getKey().getPrintOrder()))
				.map(entry -> {
					PrizeGrade prizeGrade = entry.getKey();
					return String.format(PRIZE_STATISTICS_FORMAT, prizeGrade.getStatisticsMessage(), entry.getValue());
				})
				.collect(Collectors.joining(NEW_LINE));
	}
}
