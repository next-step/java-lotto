package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class WinningNumbers {

	public static String SIZE_EXCEPTION_TEXT = String.format("당첨 넘버의 크기는 %d입니다.", Lotto.SIZE);
	public static String TYPE_EXCEPTION_TEXT = "당첨번호는 숫자만 입력 가능합니다.";
	public static String DUPLICATE_EXCEPTION_TEXT = "당첨 넘버는 중복될 수 없습니다.";

	private final Set<LottoNumber> winningNumbers = new HashSet<>();

	public WinningNumbers(String input) {
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
			throw new IllegalArgumentException(WinningNumbers.SIZE_EXCEPTION_TEXT);
		}
	}

	private void addWinNumbers(String[] split) {
		for (String winNumberString : split) {
			int winNumber = this.toInt(winNumberString);
			this.winningNumbers.add(LottoNumber.of(winNumber));
		}
	}

	private int toInt(String winNumbersString) {
		try {
			return Integer.parseInt(winNumbersString);
		} catch (Exception e) {
			throw new IllegalArgumentException(WinningNumbers.TYPE_EXCEPTION_TEXT);
		}
	}

	private void checkDuplicate(int splitLength) {
		if (this.winningNumbers.size() != splitLength) {
			throw new IllegalArgumentException(WinningNumbers.DUPLICATE_EXCEPTION_TEXT);
		}
	}

	public boolean contains(LottoNumber bonusNumber) {
		return this.winningNumbers.contains(bonusNumber);
	}

	public Set<LottoNumber> getWinningNumbers() {
		return this.winningNumbers;
	}
}
