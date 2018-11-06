package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.LottoNumberGenerator;

public class LottoMachine {

	public static final int LOTTO_PRICE = 1000;

	private int money;
	private LottoNumberGenerator lottoNumberGenerator;

	public LottoMachine(int money) {
		if(money < LOTTO_PRICE) {
			throw new IllegalArgumentException("1개 이상부터 구매 가능합니다.");
		}
		this.money = money;
		this.lottoNumberGenerator = new LottoNumberGenerator();
	}

	public LottoTicket getLottos() {
		int lottoCount = getLottoCount(money);
		List<Lotto> lottos = new ArrayList<>();
		for(int count = 1; count <= lottoCount; count++) {
			lottos.add(getLotto());
		}
		return new LottoTicket(lottos);
	}

	private int getLottoCount(int money) {
		return money / LOTTO_PRICE;
	}

	private Lotto getLotto() {
		return new Lotto(lottoNumberGenerator.pick());
	}

	public Lotto getLotto(String number) {
		return new Lotto(lottoNumberGenerator.pick(number));
	}
}
