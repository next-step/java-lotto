package lotto;

import lotto.domain.LottoTickets;
import lotto.domain.lottoTicketsStrategy.LottoTicketsStrategy;
import lotto.domain.BuyInfo;

/**
 * @author : byungkyu
 * @date : 2020/12/20
 * @description :
 **/
public class Game {

	private LottoTicketsStrategy lottoTicketsStrategy;

	public Game(LottoTicketsStrategy lottoTicketsStrategy) {
		this.lottoTicketsStrategy = lottoTicketsStrategy;
	}

	public LottoTickets play(BuyInfo buyInfo) {
		return lottoTicketsStrategy.generate(buyInfo);
	}
}
