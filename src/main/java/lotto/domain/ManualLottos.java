package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ManualLottos {

	private final List<Lotto> manualLottos;

	public ManualLottos() {
		this.manualLottos = new ArrayList<>();
	}

	public ManualLottos(List<String> inputs) {
		this.manualLottos = new ArrayList<>();
		for (String input : inputs) {
			this.manualLottos.add(new Lotto(this.createLottoNumbers(input)));
		}
	}

	public Set<LottoNumber> createLottoNumbers(String input) {
		Set<LottoNumber> lottoNumbers = new LinkedHashSet<>();
		for (String numberString : input.split(", ")) {
			lottoNumbers.add(LottoNumber.of(numberString));
		}
		return lottoNumbers;
	}

	public long size() {
		return this.manualLottos.size();
	}

	public List<Lotto> getManualLottos() {
		return this.manualLottos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ManualLottos that = (ManualLottos)o;
		return Objects.equals(manualLottos, that.manualLottos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(manualLottos);
	}
}
