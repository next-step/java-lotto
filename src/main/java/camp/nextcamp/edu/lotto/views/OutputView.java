package camp.nextcamp.edu.lotto.views;

import java.util.List;
import java.util.Map;

import camp.nextcamp.edu.lotto.entity.Lotto;
import camp.nextcamp.edu.lotto.entity.LottoTicket;
import camp.nextcamp.edu.lotto.entity.PurchasedLotto;
import camp.nextcamp.edu.lotto.entity.WinningScoreMessage;
import camp.nextcamp.edu.lotto.module.WinningScore;

public class OutputView extends View {
	private static final String WINNING = "(수익률이 엄청나군요 당신은 로또천재..?)";
	private static final String FAIL = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

	public void showLottoTicketCount(LottoTicket lottoTicket) {
		out.println(lottoTicket.getTicketCount() + "개를 구매했습니다.");
	}

	public void showPurchasedLottos(List<Lotto> lottos) {
		lottos.stream()
			.map(lotto -> "[" + lotto.getNumbersString() + "]")
			.forEach(out::println);
	}

	public void showLottoCount(PurchasedLotto purchasedLotto) {
		String result = String.format(
			"수동으로 %s장, 자동으로 %s장을 구매했습니다."
			, purchasedLotto.getManualLottoCount()
			, purchasedLotto.getAutomaticLottoCount()
		);
		out.println(result);
	}

	public void showResultStatistics(Map<WinningScore, Long> winningScore) {
		out.println("당첨 통계");
		out.println("----------");

		winningScore.forEach(this::showWinningScoreResult);
	}

	public void showProfit(double profit) {
		String message = profit > 1 ? WINNING : FAIL;
		out.println(String.format("총 수익률은 %s 입니다. %s", profit, message));
	}

	private void showWinningScoreResult(WinningScore score, Long count) {
		out.println(WinningScoreMessage.getInstance(score).getMessage(score, count));
	}
}
