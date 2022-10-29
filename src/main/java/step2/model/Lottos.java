package step2.model;

import step2.util.LottoGenerator;
import step2.util.RandomLottoGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
	private static int LOTTO_PRICE = 1000;

	private final int ticketCnt;
	private final List<Lotto> lottos;
	private final LottoGenerator lottoGenerator;

	public Lottos(final int money, final LottoGenerator lottoGenerator) {
		this.ticketCnt = money / LOTTO_PRICE;
		this.lottoGenerator = lottoGenerator;
		this.lottos = generateLottos();
	}

	private List<Lotto> generateLottos() {
		return IntStream.range(0, ticketCnt)
						.mapToObj(i -> Lotto.generate(lottoGenerator))
						.collect(Collectors.toList());
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public int getTicketCnt(){
		return ticketCnt;
	}
}
