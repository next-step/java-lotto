package camp.nextcamp.edu.lotto.entity;

import static camp.nextcamp.edu.lotto.exception.UserExceptionMesssage.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import camp.nextcamp.edu.lotto.exception.UserException;
import camp.nextcamp.edu.lotto.module.WinningScore;

public enum WinningScoreMessage {
	NONE(Collections.singletonList(WinningScore.NONE)) {
		@Override
		public String getMessage(WinningScore score, Long count) {
			return String.format("꽝\t\t\t\t(0원)  -  %s개", count);
		}
	},

	SECOND(Collections.singletonList(WinningScore.SECOND)) {
		@Override
		public String getMessage(WinningScore score, Long count) {
			return String.format("%s개 일치, 보너스볼 일치 (%s원) - %s개", score.getCorrectCount(), score.getPrice(), count);
		}
	},

	OTHERS(Arrays.asList(WinningScore.FIFTH, WinningScore.FOURTH, WinningScore.THIRD, WinningScore.FIRST)) {
		@Override
		public String getMessage(WinningScore score, Long count) {
			return String.format("%s개 일치\t\t\t (%s원) - %s개", score.getCorrectCount(), score.getPrice(), count);
		}
	};
	private final List<WinningScore> winnings;

	WinningScoreMessage(List<WinningScore> winnings) {
		this.winnings = winnings;
	}

	public static WinningScoreMessage getInstance(WinningScore score) {
		return Arrays.stream(values())
			.filter(winningScoreMessage -> winningScoreMessage.winnings.contains(score))
			.findFirst()
			.orElseThrow(() -> new UserException(NOT_CONTAINS_IN_WINNING_PRICE));
	}

	public abstract String getMessage(WinningScore score, Long count);
}
