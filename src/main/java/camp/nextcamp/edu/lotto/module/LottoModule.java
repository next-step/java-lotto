package camp.nextcamp.edu.lotto.module;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextcamp.edu.lotto.entity.Lotto;
import camp.nextcamp.edu.lotto.entity.LottoTicket;
import camp.nextcamp.edu.lotto.entity.WinningLotto;
import camp.nextcamp.edu.lotto.entity.WinningLottoInput;

public class LottoModule {

	private final Random random;

	private LottoModule() {
		this.random = new Random();
	}

	private static class LazyHolder {
		static final LottoModule INSTANCE = new LottoModule();
	}

	public static LottoModule getInstance() {
		return LazyHolder.INSTANCE;
	}

	public LottoTicket getLottoTicket(String money) {
		return new LottoTicket(money);
	}

	public List<Lotto> getLottos(LottoTicket lottoTicket) {
		return IntStream.range(0, lottoTicket.getTicketCount())
			.mapToObj((i) -> LottoNumberGenerator.generateRandomNumber(random))
			.map(Lotto::new)
			.collect(Collectors.toList());
	}

	public WinningLotto makeWinningLotto(String input, String bonusNumber) {
		WinningLottoInput winningLottoInput = new WinningLottoInput(input);

		return new WinningLotto(
			new Lotto(winningLottoInput.getNumbers()),
			LottoNumberGenerator.generate(Integer.parseInt(bonusNumber))
		);
	}

}
