package lotto;

import java.util.List;
import java.util.function.Supplier;

public class Lotto implements LottoTicket {
	private final LottoNumbers lottoNumbers;
	private final int price;
	private final LottoRank rank;

	public Lotto(List<Integer> lottoNumbers, int bonusNumber, int lottoPrice) {
		this.lottoNumbers = new LottoNumbers(lottoNumbers, bonusNumber);
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

	public LottoPaper write(LottoPaper lottoReport) {
		return lottoReport.write(this.rank, this.price);
	}

	@Override
	public String toStringLottoNumbers() {
		return this.lottoNumbers.toString();
	}
}
