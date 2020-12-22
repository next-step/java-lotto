package lotto.view;

import lotto.LottoTicket;
import lotto.LottoView;
import lotto.result.LottoResult;
import lotto.result.LottoStatistics;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGameView implements LottoView {

	private static final String MSG_INCOME_RATE_LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
	private static final String FORMAT_BUY_RESULT = "수동으로 %d장, 자동으로 %d장을 구매했습니다.";
	private static final String FORMAT_LOTTO_RESULT = "%s (%,d원)- %d개";
	private static final String FORMAT_INCOME_RATE = "총 수익률은 %.4f 입니다";

	@Override
	public void showLottoTicket(LottoTicket lottoTicket) {
		List<String> readableLottoNumbers = lottoTicket.toStringNumbers()
				.stream()
				.map(lottoNumbers -> String.format("[%s]", lottoNumbers))
				.collect(Collectors.toList());

		System.out.println(String.format(FORMAT_BUY_RESULT,
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
		return String.format(FORMAT_LOTTO_RESULT, lottoResult.getDescription(), lottoResult.getAmount(),
				lottoStatistics.getCount(lottoResult));
	}

	String createIncomeRateMessage(LottoStatistics lottoStatistics) {
		final double incomeRate = lottoStatistics.calculateIncomeRate();
		StringBuilder incomeRateMessage = new StringBuilder(String.format(FORMAT_INCOME_RATE, incomeRate));
		if (incomeRate < 1d) {
			incomeRateMessage.append(MSG_INCOME_RATE_LOSS);
		}

		return incomeRateMessage.toString();
	}
}
