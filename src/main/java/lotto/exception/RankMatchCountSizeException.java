package lotto.exception;

import lotto.domain.Rank;

public class RankMatchCountSizeException extends IllegalArgumentException {
	private static final long serialVersionUID = -8275411771942674146L;

	public RankMatchCountSizeException() {
		super(String.format("당첨번호 수는 %d ~ %d 만 가능합니다.", Rank.MIN_OF_MATCH, Rank.MAX_OF_MATCH));
	}
}
