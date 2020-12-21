package lotto.view;

import java.math.BigDecimal;
import java.util.Map;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRank;
import lotto.dto.LottoGameResultDto;

public class ResultView {
	public static void printLottoNumbers(LottoNumbers lottoNumbers) {
		for (LottoNumber lottoNumber : lottoNumbers.getLottoNumbers()) {
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
	}

	private static void printLottoRank(LottoRank lottoRank, Map<LottoRank, Long> lottoGameResult) {
		Long count = lottoGameResult.get(lottoRank);
		if (count == null) {
			count = 0L;
		}
		System.out.println(lottoRank.getCountOfMatch() + "개 일치 (" + lottoRank.getWinningMoney() + "원)- " + count + "개");
	}

	public static void printProfitRatio(LottoGameResultDto lottoGameResultDto) {
		BigDecimal profitRatio = lottoGameResultDto.getProfitRatio();
		System.out.println("총 수익률은 " + profitRatio + "입니다." + ((profitRatio.compareTo(BigDecimal.ONE) == -1) ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : ""));
	}
}
