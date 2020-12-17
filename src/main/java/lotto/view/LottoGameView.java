package lotto.view;

import lotto.result.LOTTO_RESULT;
import lotto.result.LottoStatistics;
import lotto.LottoView;
import lotto.number.LottoNumbers;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGameView implements LottoView {

	@Override
	public void showBuyLottoNumbers(List<LottoNumbers> lottoNumbersList) {
		List<String> readableLottoNumbers = lottoNumbersList.stream()
				.map(lottoNumbers -> String.format("[%s]", lottoNumbers.toString()))
				.collect(Collectors.toList());

		System.out.println(String.format("%s개를 구매했습니다.", lottoNumbersList.size()));
		System.out.println(String.join("\n", readableLottoNumbers));
	}

	@Override
	public void showStatistics(LottoStatistics lottoStatistics) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		System.out.println(createLottoMatchedCountMessage(lottoStatistics, LOTTO_RESULT.MATCHED_THREE));
		System.out.println(createLottoMatchedCountMessage(lottoStatistics, LOTTO_RESULT.MATCHED_FOUR));
		System.out.println(createLottoMatchedCountMessage(lottoStatistics, LOTTO_RESULT.MATCHED_FIVE));
		System.out.println(createLottoMatchedCountMessage(lottoStatistics, LOTTO_RESULT.MATCHED_SIX));
		System.out.println(createIncomeRateMessage(lottoStatistics));
	}

	private String createLottoMatchedCountMessage(LottoStatistics lottoStatistics, LOTTO_RESULT lottoResult) {
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
