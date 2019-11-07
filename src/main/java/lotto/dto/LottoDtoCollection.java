package lotto.dto;

import lotto.domain.lotto.LottoType;

import java.util.List;
import java.util.stream.Collectors;

public class LottoDtoCollection {

	private final List<LottoDto> lottoDtos;

	public LottoDtoCollection(List<LottoDto> lottoDtos) {
		this.lottoDtos = lottoDtos;
	}

	public long selfLottoCount() {
		return lottoDtos.stream()
				.filter(dto -> dto.hasType(LottoType.SELF))
				.count();
	}

	public long autoLottoCount() {
		return lottoDtos.stream()
				.filter(dto -> dto.hasType(LottoType.AUTO))
				.count();
	}

	public List<LottoDto> getAutoLottoDtos() {
		return lottoDtos.stream()
				.filter(dto -> dto.hasType(LottoType.AUTO))
				.collect(Collectors.toList());
	}

}
