package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.WinningNumber;
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

	public WinningLotto getWinningLotto(WinningNumber winningNumber) {
		List<Integer> numbers= lottoNumberGenerator.pick(winningNumber.getWinningNumber());
		int bonusNumber = winningNumber.getBonusNumber();
		if(numbers.contains(bonusNumber)) {
			throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
		}
		return new WinningLotto(numbers, bonusNumber);
	}
}
