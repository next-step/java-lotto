package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

	private final Lotto lotto;

	public WinningLotto(String numbers) {
		List<LottoNumber> lottoNumberList = new ArrayList<>();
		for (String lottoNumber : numbers.split(",")) {
			lottoNumberList.add(new LottoNumber(Integer.parseInt(lottoNumber.trim())));
		}
		lotto = new Lotto(lottoNumberList);
	}

	public Lotto getLotto() {
		return lotto;
	}

	public Rank rank(Lotto lotto) {
		return Rank.from(this.lotto.countMatch(lotto));
	}
}
