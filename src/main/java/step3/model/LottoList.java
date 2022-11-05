package step3.model;

import step3.util.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoList {
	private final List<Lotto> lottoList = new ArrayList<>();
	private final int ticketCnt;
	private final LottoGenerator lottoGenerator;

	public LottoList(Money money, LottoGenerator lottoGenerator) {
		this.ticketCnt = money.getLottoTicketCnt();
		this.lottoGenerator = lottoGenerator;
		generate();
	}

	private void generate(){
		IntStream.range(0, ticketCnt)
				.mapToObj(lotto -> new Lotto(lottoGenerator))
				.forEach(lottoList::add);
	}

	public List<Lotto> getLottoList() {
		return lottoList;
	}
}
