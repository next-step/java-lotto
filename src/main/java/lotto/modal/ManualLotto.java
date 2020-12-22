package lotto.modal;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ManualLotto {

	private final List<Lotto> lottoBundle;

	public ManualLotto(int count) {

		this.lottoBundle = generateRandomLotto(count);
	}

	public ManualLotto(List<Lotto> lottoBundle) {
		this.lottoBundle = lottoBundle;
	}

	public List<Lotto> getLottoBundle() {
		return this.lottoBundle;
	}

	private List<Lotto> generateRandomLotto(int count) {
		return Stream.generate(Lotto::new)
			.limit(count)
			.collect(Collectors.toList());
	}

	public List<Lotto> mergeLotto(ManualLotto randomLotto) {
		return Stream.concat(this.lottoBundle.stream(), randomLotto.getLottoBundle().stream())
			.collect(Collectors.toList());
	}
}
