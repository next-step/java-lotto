package kht2199.lotto;

/**
 *
 * Data class.
 *
 * @author heetaek.kim
 */
public final class LottoResult {

	private final int matched;

	private final int prize;

	public LottoResult(int matched, int prize) {
		this.matched = matched;
		this.prize = prize;
	}

	public int getMatched() {
		return matched;
	}

	public int getPrize() {
		return prize;
	}
}
