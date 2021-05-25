package domain;

import java.math.BigDecimal;

public class LottoOrderGroupAnalysis {
	private final Integer[] winnerNumbers;
	private final LottoOrderGroup lottoOrderGroup;
	private Integer match3;
	private Integer match4;
	private Integer match5;
	private Integer match6;

	public LottoOrderGroupAnalysis (Integer[] winnerNumbers, LottoOrderGroup lottoOrderGroup) {
		this.winnerNumbers = winnerNumbers;
		this.lottoOrderGroup = lottoOrderGroup;
	}

	public Integer yield () {
		return new BigDecimal(0).intValue();
	}

	public Integer match3 () {
		return match3;
	}

	public Integer match4 () {
		return match4;
	}

	public Integer match5 () {
		return match5;
	}

	public Integer match6 () {
		return match6;
	}
}
