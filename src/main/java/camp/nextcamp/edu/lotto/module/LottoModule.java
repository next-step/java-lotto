package camp.nextcamp.edu.lotto.module;

import camp.nextcamp.edu.lotto.entity.Lotto;
import camp.nextcamp.edu.lotto.entity.LottoNumber;
import camp.nextcamp.edu.lotto.entity.WinningLotto;
import camp.nextcamp.edu.lotto.entity.LottoInput;

public class LottoModule {

	private LottoModule() {
	}

	private static class LazyHolder {
		static final LottoModule INSTANCE = new LottoModule();
	}

	public static LottoModule getInstance() {
		return LazyHolder.INSTANCE;
	}

	public WinningLotto makeWinningLotto(String input, String bonusNumber) {
		LottoInput lottoInput = new LottoInput(input);

		return new WinningLotto(
			new Lotto(lottoInput.getNumbers()),
			LottoNumber.valueOf(Integer.parseInt(bonusNumber))
		);
	}

}
