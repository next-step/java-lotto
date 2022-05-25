package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class PurchaseLottoGroup {
	private final List<Lotto> lottoGroup;

	private PurchaseLottoGroup(List<Lotto> lottos) {
		this.lottoGroup = lottos;
	}

	public static PurchaseLottoGroup create(List<Lotto> manualLottoGroup, long autoQuantity) {
		validateLottoGroup(manualLottoGroup);

		List<Lotto> lottoGroup = new ArrayList<>(manualLottoGroup);
		lottoGroup.addAll(LongStream.rangeClosed(1, autoQuantity)
			.mapToObj(num -> Lotto.createAuto())
			.collect(Collectors.toList()));

		return new PurchaseLottoGroup(lottoGroup);
	}

	private static void validateLottoGroup(List<Lotto> lottoGroup) {
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
