package lotto.ui;

import java.util.List;

import lotto.dto.LottoDto;
import lotto.dto.PrizeDto;

public class ResultView {
	public static final String INFO_INTRO = "당첨 통계\n---------";
	public static final String FORMAT_PROFIT = "총 수익률은 %.2f 입니다.%n";
	public static final String FORMAT_DEFAULT_STATISTICS = "%d개 일치 (%s원) - %d개%n";
	public static final String FORMAT_SECOND_STATISTICS = "%d개 일치, 보너스볼 일치 (%s원) - %d개%n";

	public void output(List<PrizeDto> prizeDtos) {
		System.out.println(INFO_INTRO);
		for (PrizeDto prizeDto : prizeDtos) {
			String formatter = getFormatter(prizeDto);
			System.out.printf(formatter, prizeDto.count(), prizeDto.amount(), prizeDto.status());
		}
	}

	private String getFormatter(PrizeDto prizeDto) {
		return (prizeDto.isBonusMatch()) ? FORMAT_SECOND_STATISTICS : FORMAT_DEFAULT_STATISTICS;
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

