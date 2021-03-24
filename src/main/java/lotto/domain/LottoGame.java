package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoGame {
	List<LottoNumber> gameNumberList;

	public LottoGame(MakeStrategy makeStrategy) {
		this.gameNumberList = makeStrategy.makeGameNumberList();
		if (gameNumberList.size() != 6) {
			throw new IllegalArgumentException("로또 번호는 반드시 6자리로 구성 돼야 합니다.");
		}
		Collections.sort(this.gameNumberList);
	}

	public List<LottoNumber> getGameNumberList() {
		return gameNumberList;
	}

}
