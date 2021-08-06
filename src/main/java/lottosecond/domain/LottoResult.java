package lottosecond.domain;

import java.util.*;

public class LottoResult {

	private static final int MATCHING_STANDARD = 2;
	private static final String WINNING_NUMBER_MESSAGE = "당첨번호는 숫자만 입력 가능합니다.";

	private final Map<LottoProfit, Integer> result = new EnumMap<>(LottoProfit.class);
	private final Lottos lottos;

	public LottoResult(Lottos lottos) {
		this.lottos = lottos;
		result.put(LottoProfit.THREE, 0);
		result.put(LottoProfit.FOUR, 0);
		result.put(LottoProfit.FIVE, 0);
		result.put(LottoProfit.FIVE_BONUS, 0);
		result.put(LottoProfit.SIX, 0);
	}

	public void match(String winningNumberText, int bonusNumber) {
		putIntoMap(toLotto(winningNumberText), bonusNumber);
	}

	private Lotto toLotto(String winningNumberText) {
		String[] winningNumberTexts = winningNumberText.split(",");
		return new Lotto(toList(winningNumberTexts));
	}

	private List<Integer> toList(String[] split) {
		List<Integer> winningNumbers = new ArrayList<>();
		for (String s : split) {
			winningNumbers.add(toInt(s));
		}
		return winningNumbers;
	}

	private int toInt(String s) {
		int number;
		try {
			number = Integer.parseInt(s.trim());
		} catch (NumberFormatException e) {
			throw new NumberFormatException(WINNING_NUMBER_MESSAGE);
		}
		return number;
	}

	private void putIntoMap(Lotto winningNumbers, int bonusNumber) {
		for (Lotto lotto : lottos.toList()) {
			int quantity = lotto.matchingQuantityFrom(winningNumbers);
			boolean matchBonus = lotto.hasBonus(bonusNumber);
			putResult(quantity, matchBonus);
		}
	}

	private void putResult(int quantity, boolean matchBonus) {
		if (quantity > MATCHING_STANDARD) {
			LottoProfit lottoProfit = LottoProfit.from(quantity, matchBonus);
			result.put(lottoProfit, getMatchingCount(lottoProfit));
		}
	}

	private int getMatchingCount(LottoProfit quantity) {
		return result.containsKey(quantity) ? result.get(quantity) + 1 : 1;
	}

	public double rate() {
		return rate(profitCount());
	}

	private int profitCount() {
		int totalProfitCount = 0;
		for (Map.Entry<LottoProfit, Integer> entry : result.entrySet()) {
			totalProfitCount += entry.getValue();
		}
		return totalProfitCount;
	}

	private double rate(double totalProfitCount) {
		return totalProfitCount / lottos.size();
	}

	public Map<LottoProfit, Integer> value() {
		return Collections.unmodifiableMap(result);
	}

}
