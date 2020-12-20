package lotto.domain.lottoTicketsStrategy;

import lotto.domain.BuyInfo;
import lotto.domain.LottoTickets;

/**
 * @author : byungkyu
 * @date : 2020/12/20
 * @description :
 **/
public interface LottoTicketsStrategy {
	LottoTickets generate(BuyInfo buyInfo);
}
