package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

	public static Lottos issue(final LottoPurchase lottoPurchase) {
		List<Lotto> lottos = new ArrayList<>();
		lottos.addAll(LottoMachine.autoNumberIssue(lottoPurchase.getAutoLottoIssueCount()));
		lottos.addAll(lottoPurchase.getManualLottoNumbers().stream()
			.map(Lotto::new)
			.collect(Collectors.toList()));
		return new Lottos(lottos);
	}

	private static List<Lotto> autoNumberIssue(final int autoLottoIssueCount) {
		List<Lotto> lottos = new ArrayList<>();
		while (lottos.size() < autoLottoIssueCount) {
			lottos.add(new Lotto(LottoNumberGenerator.generate()));
		}
		return lottos;
	}

}
