package lotto.view;

import java.math.BigDecimal;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.LottoRank;
import lotto.dto.LottoGameResultDto;

public class ResultView {
	public static void printLottoNumbers(LottoTicket lottoTicket) {
		for (Lotto lottoNumber : lottoTicket.getLottoTicket()) {
			System.out.println(lottoNumber);
		}
		System.out.println();
	}

	public static void printLottoGameCount(int lottoGameCount) {
		System.out.println(lottoGameCount + "개를 구매했습니다.");
	}

	public static void printLottoGameStatistic(LottoGameResultDto lottoGameResultDto) {
		Map<LottoRank, Long> lottoGameResult = lottoGameResultDto.getLottoGameResult();
		System.out.println("당첨 통계");
		System.out.println("---------");
		printLottoRank(LottoRank.FOURTH, lottoGameResult);
		printLottoRank(LottoRank.THIRD, lottoGameResult);
		printLottoRank(LottoRank.SECOND, lottoGameResult);
		printLottoRank(LottoRank.FIRST, lottoGameResult);
		printProfitRatio(lottoGameResultDto);
	}

	private static void printLottoRank(LottoRank lottoRank, Map<LottoRank, Long> lottoGameResult) {
		long count = lottoGameResult.getOrDefault(lottoRank, 0L);
		System.out.println(lottoRank.getCountOfMatch() + "개 일치 (" + lottoRank.getWinningMoney() + "원)- " + count + "개");
	}

	private static void printProfitRatio(LottoGameResultDto lottoGameResultDto) {
		System.out.println("총 수익률은 " + lottoGameResultDto.getProfitRatio() + "입니다.");
	}
}
