package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseLottoGroup {
	private final List<Lotto> lottoGroup;

	private PurchaseLottoGroup(List<Lotto> lottoGroup) {
		this.lottoGroup = lottoGroup;
	}

	public static PurchaseLottoGroup create(List<Lotto> manualLottoGroup, List<Lotto> autoLottoGroup) {
		validateNull(manualLottoGroup);
		validateNull(autoLottoGroup);
		validateLottoGroup(manualLottoGroup, autoLottoGroup);

		List<Lotto> lottoGroup = new ArrayList<>(manualLottoGroup);
		lottoGroup.addAll(autoLottoGroup);
		return new PurchaseLottoGroup(lottoGroup);
	}

	private static void validateLottoGroup(List<Lotto> manualLottoGroup, List<Lotto> autoLottoGroup) {
		List<Lotto> lottoGroup = new ArrayList<>(manualLottoGroup);
		lottoGroup.addAll(autoLottoGroup);

		if (lottoGroup.isEmpty()) {
			throw new IllegalArgumentException("구매한 로또는 0개일 수 없습니다.");
		}
	}

	private static void validateNull(List<Lotto> lottoGroup) {
		if (lottoGroup == null) {
			throw new IllegalArgumentException("구매한 로또는 null 일 수 없습니다.");
		}
	}

	public int size() {
		return lottoGroup.size();
	}

	public List<LottoRank> ranking(WinningNumbers winningNumbers) {
		return lottoGroup.stream()
			.map(winningNumbers::ranking)
			.collect(Collectors.toList());
	}

	public List<Lotto> values() {
		return lottoGroup;
	}
}
