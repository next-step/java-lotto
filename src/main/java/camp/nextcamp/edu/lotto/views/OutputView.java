package camp.nextcamp.edu.lotto.views;

import java.util.List;
import java.util.Map;

import camp.nextcamp.edu.lotto.entity.Lotto;
import camp.nextcamp.edu.lotto.entity.LottoTicket;
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

	public void showResultStatistics(Map<WinningScore, Long> winningScore) {
		out.println("당첨 통계");
		out.println("----------");
		winningScore.forEach((key, value) -> {
			String result = key + " - " + value + "개";
			out.println(result);
		});
	}

	public void showProfit(double profit) {
		String message = profit > 1 ? WINNING : FAIL;
		String result =
			"총 수익률은 "
			+ profit
			+ "입니다."
			+ message;
		out.println(result);
	}
}
