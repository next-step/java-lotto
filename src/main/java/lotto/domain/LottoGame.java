package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGame {
	private static final int LOTTO_NUMBER_SIZE = 6;
	private final List<LottoNumber> gameNumberList;

	public LottoGame(MakeStrategy makeStrategy) {
		this.gameNumberList = makeStrategy.makeGameNumberList();
		validateSize(gameNumberList);
		validateDuplicate(gameNumberList);
		Collections.sort(this.gameNumberList);
	}

	public List<LottoNumber> getGameNumberList() {
		return gameNumberList;
	}

	private void validateSize(List<LottoNumber> gameNumberList) {
		if (gameNumberList.size() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException("로또 번호는 반드시 6자리로 구성 돼야 합니다.");
		}
	}

	private void validateDuplicate(List<LottoNumber> gameNumberList) {
		Set<LottoNumber> nonDuplicateNumbers = new HashSet<>(gameNumberList);
		if (nonDuplicateNumbers.size() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException("로또 번호들은 중복될 수 없습니다.");
		}
	}
}
