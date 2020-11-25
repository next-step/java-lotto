package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
	private List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public static List<Lotto> purchaseManualLottos(String manualLottos) {
		String[] lottoNumbers = manualLottos.split(":");
		List<Lotto> lottos = new ArrayList<>(lottoNumbers.length);
		for(String numbers : lottoNumbers) {
			lottos.add(Lotto.of(numbers));
		}
		return lottos;
	}

	public static List<Lotto> purchaseAutoLottos(int lottoCount) {
		List<Lotto> lottos = new ArrayList<>(lottoCount);
		for(int i = 0; i < lottoCount; i++) {
			lottos.add(LottoAutoGenerator.getAutoNumbers());
		}
		return lottos;
	}

	public static Lottos mergeLottos(String lottoNumbers, int lottoCount) {
		List<Lotto> manualLottos = purchaseManualLottos(lottoNumbers);
		List<Lotto> autoLottos = purchaseAutoLottos(lottoCount);

		return Stream.of(manualLottos, autoLottos)
				.flatMap(Collection::stream)
				.collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
	}
}
