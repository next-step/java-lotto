package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGames {
	private final List<Lotto> lottoList = new ArrayList<>();

	public LottoGames(int gameSize) {
		this(IntStream.rangeClosed(1, gameSize)
			.mapToObj(n -> new Lotto(new ShuffleMakeStrategy()))
			.toArray(Lotto[]::new));
	}

	public LottoGames(Lotto... lotto) {
		for (int i = 0; i < lotto.length; i++) {
			lottoList.add(lotto[i]);
		}
	}

	public List<Lotto> getLottoGameList() {
		return lottoList;
	}
}
