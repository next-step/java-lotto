package nextstep.step2.domain;

import java.util.List;

public class Lotto {
	private LottoAutoGenerator lottoAutoGenerator;

	public Lotto(LottoAutoGenerator lottoAutoGenerator) {
		this.lottoAutoGenerator = lottoAutoGenerator;
	}

	public List<Integer> getLottoNumbers() {
		return lottoAutoGenerator.getAutoNumbers();
	}
}
