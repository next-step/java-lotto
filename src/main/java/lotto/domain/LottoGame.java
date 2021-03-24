package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoGame {
	List<LottoNumber> gameNumberList;

	public LottoGame(MakeStrategy makeStrategy) {
		this.gameNumberList = makeStrategy.makeGameNumberList();
		Collections.sort(this.gameNumberList);
	}

	public List<LottoNumber> getGameNumberList() {
		return gameNumberList;
	}

}
