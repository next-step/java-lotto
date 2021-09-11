package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto implements LottoTicket {
	public static final String INVALID_NUMBER_COUNT = "잘못된 로또 숫자입니다.";
	private final List<LottoNumber> lottoNumbers;
	private final int price;
	private final LottoRank rank;

	public Lotto(List<Integer> lottoNumbers, int lottoPrice) {
		if (!this.validate(lottoNumbers)) {
			throw new IllegalArgumentException(INVALID_NUMBER_COUNT);
		}
		this.lottoNumbers = lottoNumbers
			.stream()
			.map(LottoNumber::new)
			.collect(Collectors.toList());
		this.price = lottoPrice;
		this.rank = LottoRank.NOTHING;
	}

	public Lotto(List<Integer> numbers) {
		this(numbers, 0);
	}

	public Lotto(List<LottoNumber> lottoNumbers, int price, LottoRank lottoRank) {
		this.lottoNumbers = lottoNumbers;
		this.price = price;
		this.rank = lottoRank;
	}

	private boolean validate(List<Integer> lottoNumbers) {
		if (lottoNumbers.size() != LottoRule.LOTTO_NUMBER_COUNT) {
			return false;
		}
		return true;
	}

	public LottoPaper write(LottoPaper lottoReport) {
		return lottoReport.write(this.rank, this.price);
	}

	public int matchNumber(Lotto lotto) {
		return (int)this.lottoNumbers
			.stream()
			.filter(lotto::contains)
			.count();
	}

	public boolean contains(LottoNumber bonusNumber) {
		return this.lottoNumbers.contains(bonusNumber);
	}

	public Lotto copyWithoutRank(LottoRank rank) {
		return new Lotto(this.lottoNumbers, this.price, rank);
	}

	@Override
	public List<Integer> lottoNumbers() {
		return this.lottoNumbers
			.stream()
			.map(LottoNumber::toInteger)
			.collect(Collectors.toList());
	}
}
