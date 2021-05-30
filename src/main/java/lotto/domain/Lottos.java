package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Lottos {
	public static final ArrayList<Lotto> EMPTY_LOTTOS = new ArrayList<>();
	private static final int MAXIMUM_LOTTOS_SIZE = 100;

	private final List<Lotto> automaticLottos;
	private final List<Lotto> manualLottos;

	public Lottos(List<Lotto> automaticLottos) {
		this(automaticLottos, EMPTY_LOTTOS);
	}

	public Lottos(List<Lotto> automaticLottos, List<Lotto> manualLottos) {
		this.automaticLottos = automaticLottos;
		this.manualLottos = manualLottos;

		validateLottosSize();
	}

	private void validateLottosSize() {
		if (automaticLottos.size() + manualLottos.size() > MAXIMUM_LOTTOS_SIZE) {
			throw new RuntimeException("the size of lottos can not exceed 100");
		}
	}

	public int getTotalSize() {
		return automaticLottos.size() + manualLottos.size();
	}

	public int getAutomaticLottosSize() {
		return automaticLottos.size();
	}

	public int getManualLottosSize() {
		return manualLottos.size();
	}

	public WinnerTable announce(WinnerLotto winnerLotto) {
		WinnerTable winnerTable = new WinnerTable();

		for (Lotto lotto : automaticLottos) {
			winnerTable.count(winnerLotto.match(lotto));
		}

		for (Lotto lotto : manualLottos) {
			winnerTable.count(winnerLotto.match(lotto));
		}

		return winnerTable;
	}

	public void forEachLottos(Consumer<Lotto> lamda) {
		manualLottos.forEach(lamda);
		automaticLottos.forEach(lamda);
	}
}
