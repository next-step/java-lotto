package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTicket {
	private final List<LottoNumbers> lottoNumbers;

	public LottoTicket(List<LottoNumbers> lottoNumbers) {
		this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
	}

	public static LottoTicket purchase(int numberOfTicket) {
		List<LottoNumbers> lottoNumbers = new ArrayList<>();
		IntStream.range(0, numberOfTicket).forEach(amount -> lottoNumbers.add(LottoNumberGenerator.auto()));
		return new LottoTicket(lottoNumbers);
	}

	public List<LottoNumbers> getLottoNumbers() {
		return lottoNumbers;
	}
}
