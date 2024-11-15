package step2.dto;

import java.util.ArrayList;
import java.util.List;

import step2.domain.Lotto;
import step2.domain.Money;

public class LottoPlayResultDto {
	private final List<Lotto> manualLottos;
	private final List<Lotto> autoLottos;
	private final Money change;

	public LottoPlayResultDto(List<Lotto> manualLottos, List<Lotto> autoLottos, Money change) {
		this.manualLottos = manualLottos;
		this.autoLottos = autoLottos;

		this.change = change;
	}

	public List<Lotto> getLottos() {
		List<Lotto> result = new ArrayList<>();
		result.addAll(manualLottos);
		result.addAll(autoLottos);
		return new ArrayList<>(result);
	}

	public List<Lotto> getManualLottos() {
		return new ArrayList<>(manualLottos);
	}

	public List<Lotto> getAutoLottos() {
		return new ArrayList<>(autoLottos);
	}

	public Money getChange() {
		return change;
	}
}
