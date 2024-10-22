package step2.dto;

import java.util.ArrayList;
import java.util.List;

import step2.domain.Lotto;
import step2.domain.Money;

public class LottoPlayResultDto {
	private final List<Lotto> lottos;
	private final Money change;

	public LottoPlayResultDto(List<Lotto> lottos, Money change) {
		this.lottos = lottos;
		this.change = change;
	}

	public List<Lotto> getLottos() {
		return new ArrayList<>(lottos);
	}

	public Money getChange() {
		return change;
	}
}
