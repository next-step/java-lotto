package lotto.domain.lottoTicketsStrategy;

import lotto.domain.LottoTickets;
import lotto.domain.BuyInfo;

/**
 * @author : byungkyu
 * @date : 2020/12/20
 * @description :
 **/
public interface LottoTicketsStrategy {
	LottoTickets generate(BuyInfo buyInfo);
}
