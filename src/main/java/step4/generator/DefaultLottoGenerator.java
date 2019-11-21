package step4.generator;

import step4.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultLottoGenerator implements LottoGenerator {
	private LottoGenerator autoLottoGenerator = new AutoLottoGenerator();
	private final List<Lotto> lottos;

	public DefaultLottoGenerator(String inputManualLotto) {
		lottos = Arrays.stream(inputManualLotto.split("\r?\n"))
				.map(s -> Lotto.ofComma(s))
				.collect(Collectors.toList());
	}

	public DefaultLottoGenerator(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	@Override
	public List<Lotto> generate(int money) {
		money -= lottos.size() * AutoLottoGenerator.LOTTO_PRICE;
		lottos.addAll(autoLottoGenerator.generate(money));
		return lottos;
	}
}
