package step2.model;

import step2.util.LottoGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
	private final static int LOTTO_PRICE = 1000;

	private final int ticketCnt;
	private final Money money;
	private final List<Lotto> lottos;
	private final LottoGenerator lottoGenerator;

	public Lottos(final Money money, final LottoGenerator lottoGenerator) {
		this.money = money;
		this.ticketCnt = this.money.getTicketCnt();
		this.lottoGenerator = lottoGenerator;
		lottos = generateLottos();
	}

	private List<Lotto> generateLottos() {
		return IntStream.range(0, ticketCnt)
						.mapToObj(i -> Lotto.generate(lottoGenerator))
						.collect(Collectors.toList());
	}


	public List<Lotto> getLottos() {
		return lottos;
	}

	public int getTicketCnt() {
		return ticketCnt;
	}
}
