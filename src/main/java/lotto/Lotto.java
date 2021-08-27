package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
	public static final int DEFAULT_PRICE = 1000;
	private final LottoNumbers lottoNumbers;
	private final int price;
	private final LottoRank rank;

	public Lotto(List<Integer> numbers) {
		this(numbers, DEFAULT_PRICE);
	}

	public Lotto(List<Integer> numbers, int defaultPrice) {
		this.lottoNumbers = new LottoNumbers(numbers);
		this.price = defaultPrice;
		this.rank = LottoRank.NOTHING;
	}

	public Lotto(List<Integer> numbers, int lottoPrice, int lottoNumberCount) {
		this.lottoNumbers = new LottoNumbers(numbers, lottoNumberCount);
		this.price = lottoPrice;
		this.rank = LottoRank.NOTHING;
	}

	public Lotto(LottoNumbers lottoNumbers, int price, LottoRank lottoRank) {
		this.lottoNumbers = lottoNumbers;
		this.price = price;
		this.rank = lottoRank;
	}

	public Lotto unmaskedLotto(Lotto other) {
		return new Lotto(this.lottoNumbers, this.price, LottoRank.findLottoRank(this.lottoNumbers, other.lottoNumbers));
	}

	public LottoRank lottoRank() {
		return this.rank;
	}
}
