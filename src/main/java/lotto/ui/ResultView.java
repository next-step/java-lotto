package lotto.ui;

import java.util.List;

import lotto.dto.LottoDto;
import lotto.dto.PrizeDto;

public class ResultView {
	public static final String INFO_INTRO = "당첨 통계\n---------";
	public static final String FORMAT_PROFIT = "총 수익률은 %.2f 입니다.%n";
	public static final String FORMAT_STATISTICS = "%d개 일치 (%s원) - %d개%n";

	public void output(List<PrizeDto> prizeDtos) {
		System.out.println(INFO_INTRO);
		for (PrizeDto prizeDto : prizeDtos) {
			System.out.printf(FORMAT_STATISTICS, prizeDto.count(), prizeDto.amount(), prizeDto.status());
		}
	}

	public void outputProfit(double rate) {
		System.out.printf(FORMAT_PROFIT, rate);
	}

	public void printNumbers(List<LottoDto> numbers) {
		for (LottoDto lottoDto : numbers) {
			System.out.println(lottoDto.lottoNumbers());
		}

	}
}

