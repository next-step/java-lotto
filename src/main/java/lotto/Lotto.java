package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
	public static final int DEFAULT_PRICE = 1000;
	private final LottoNumbers lottoNumbers;
	private final int price;
	private final LottoRank rank;

	public Lotto(List<Integer> numbers) {
		LottoNumbers lottoNumbers = new LottoNumbers(numbers
			.stream()
			.map(number -> new LottoNumber(number))
			.collect(Collectors.toList()));

		this.lottoNumbers = lottoNumbers;
		this.price = DEFAULT_PRICE;
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
