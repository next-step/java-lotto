package camp.nextcamp.edu.lotto.module;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextcamp.edu.lotto.entity.Lotto;
import camp.nextcamp.edu.lotto.entity.LottoTicket;
import camp.nextcamp.edu.lotto.entity.WinningLottoInput;

public class LottoModule {

	private LottoModule() {
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
			.boxed()
			.map((i) -> LottoRandomGenerator.generate(new Random()))
			.map(Lotto::new)
			.collect(Collectors.toList());
	}

	public Lotto makeWinningLotto(String input) {
		WinningLottoInput winningLottoInput = new WinningLottoInput(input);
		return new Lotto(winningLottoInput.getNumbers());
	}

}
