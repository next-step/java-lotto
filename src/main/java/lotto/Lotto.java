package lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lotto implements Iterable<LottoNumber> {
	private final List<LottoNumber> lottoNumbers;

	public Lotto() {
		this.lottoNumbers = LottoFactory.createLotto();
	}

	public Lotto(List<Integer> inputLottoNumbers) {
		this.lottoNumbers = new ArrayList<>();
		for (int lottoNumber : inputLottoNumbers) {
			lottoNumbers.add(new LottoNumber(lottoNumber));
		}
	}

	public List<LottoNumber> lottoNumbers() {
		return this.lottoNumbers;
	}

	@Override
	public Iterator<LottoNumber> iterator() {
		return this.lottoNumbers.iterator();
	}
}
