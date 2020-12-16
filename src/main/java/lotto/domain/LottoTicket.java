package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {
	private final List<LottoNumbers> lottoNumbers;

	public LottoTicket(List<LottoNumbers> lottoNumbers) {
		this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
	}

	public static LottoTicket ofNumbers(List<LottoNumbers> purchaseLottoNumbers) {
		return new LottoTicket(purchaseLottoNumbers);
	}

	public List<LottoNumbers> getLottoNumbers() {
		return this.lottoNumbers;
	}

	public LottoTicket combine(LottoTicket lottoTicket) {
		return new LottoTicket(Stream.concat(
			this.lottoNumbers.stream(),
			lottoTicket.getLottoNumbers().stream())
			.collect(Collectors.toList()));
	}
}
