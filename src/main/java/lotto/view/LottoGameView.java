package lotto.view;

import lotto.LottoTicket;
import lotto.LottoView;
import lotto.result.LottoResult;
import lotto.result.LottoStatistics;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGameView implements LottoView {

	@Override
	public void showLottoTicket(LottoTicket lottoTicket) {
		List<String> readableLottoNumbers = lottoTicket.toStringNumbers()
				.stream()
				.map(lottoNumbers -> String.format("[%s]", lottoNumbers))
				.collect(Collectors.toList());

		System.out.println(String.format("수동으로 %d장, 자동으로 %d장을 구매했습니다.",
				lottoTicket.manualNumbersSize(), lottoTicket.autoNumbersSize()));
		System.out.println(String.join("\n", readableLottoNumbers));
	}

	@Override
	public void showStatistics(LottoStatistics lottoStatistics) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		System.out.println(createLottoMatchedCountMessage(lottoStatistics, LottoResult.MATCHED_THREE));
		System.out.println(createLottoMatchedCountMessage(lottoStatistics, LottoResult.MATCHED_FOUR));
		System.out.println(createLottoMatchedCountMessage(lottoStatistics, LottoResult.MATCHED_FIVE));
		System.out.println(createLottoMatchedCountMessage(lottoStatistics, LottoResult.MATCHED_FIVE_WITH_BONUS));
		System.out.println(createLottoMatchedCountMessage(lottoStatistics, LottoResult.MATCHED_SIX));
		System.out.println(createIncomeRateMessage(lottoStatistics));
	}

	private String createLottoMatchedCountMessage(LottoStatistics lottoStatistics, LottoResult lottoResult) {
		return String.format("%s (%,d원)- %d개", lottoResult.getDescription(), lottoResult.getAmount(),
				lottoStatistics.getCount(lottoResult));
	}

	String createIncomeRateMessage(LottoStatistics lottoStatistics) {
		final double incomeRate = lottoStatistics.calculateIncomeRate();
		StringBuilder incomeRateMessage = new StringBuilder(String.format("총 수익률은 %.4f 입니다", incomeRate));
		if (incomeRate < 1d) {
			incomeRateMessage.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
		}

		return incomeRateMessage.toString();
	}
}
