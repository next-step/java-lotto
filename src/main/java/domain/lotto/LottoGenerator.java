package domain.lotto;

import static java.util.Collections.*;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

	private static final List<LottoNumber> ALL_NUMBERS = new ArrayList<>();

	static {
		for (int i = 1; i < 46; i++) {
			ALL_NUMBERS.add(new LottoNumber(i));
		}
	}

	public Lotto generate() {
		shuffle(ALL_NUMBERS);
		List<LottoNumber> lottoNumbers = ALL_NUMBERS.subList(0, 6);
		return new Lotto(lottoNumbers);
	}
}
