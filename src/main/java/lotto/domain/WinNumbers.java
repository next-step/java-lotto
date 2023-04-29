package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class WinNumbers {

	public static String SIZE_EXCEPTION_TEXT = String.format("당첨 넘버의 크기는 %d입니다.", Lotto.SIZE);
	public static String TYPE_EXCEPTION_TEXT = "당첨번호는 숫자만 입력 가능합니다.";
	public static String RANGE_EXCEPTION_TEXT = String.format("당첨 넘버는 %d~%d까지의 숫자만 입력 가능합니다.", Lotto.MINIMUM_BOUND, Lotto.MAXIMUM_BOUND);
	public static String DUPLICATE_EXCEPTION_TEXT = "당첨 넘버는 중복될 수 없습니다.";

	private final Set<Integer> winNumbers = new HashSet<>();

	public WinNumbers(String input) {
		String[] split = this.split(input);
		this.checkSize(split);
		this.addWinNumbers(split);
		this.checkDuplicate(split.length);
	}

	private String[] split(String input) {
		return input.split(", ");
	}

	private void checkSize(String[] split) {
		if (split.length != Lotto.SIZE) {
			throw new IllegalArgumentException(WinNumbers.SIZE_EXCEPTION_TEXT);
		}
	}

	private void addWinNumbers(String[] split) {
		for (String winNumberString : split) {
			int winNumber = this.toInt(winNumberString);
			this.checkRange(winNumber);
			winNumbers.add(winNumber);
		}
	}

	private int toInt(String winNumbersString) {
		try {
			return Integer.parseInt(winNumbersString);
		} catch (Exception e) {
			throw new IllegalArgumentException(WinNumbers.TYPE_EXCEPTION_TEXT);
		}
	}

	private void checkRange(int winNumber) {
		if (winNumber < Lotto.MINIMUM_BOUND || winNumber > Lotto.MAXIMUM_BOUND) {
			throw new IllegalArgumentException(WinNumbers.RANGE_EXCEPTION_TEXT);
		}
	}

	private void checkDuplicate(int splitLength) {
		if (this.winNumbers.size() != splitLength) {
			throw new IllegalArgumentException(WinNumbers.DUPLICATE_EXCEPTION_TEXT);
		}
	}

	public Score plusScore(LottoNumbers lottoNumbers, Score score) {
		for (Integer winNumber : this.winNumbers) {
			this.plus(lottoNumbers, score, winNumber);
		}
		return score;
	}

	private void plus(LottoNumbers lottoNumbers, Score score, Integer winNumber) {
		if (lottoNumbers.contains(winNumber)) {
			score.plus();
		}
	}
}
