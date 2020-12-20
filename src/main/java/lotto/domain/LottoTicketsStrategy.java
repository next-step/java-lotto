package lotto.domain;

import java.util.List;

import lotto.view.BuyInfo;

/**
 * @author : byungkyu
 * @date : 2020/12/20
 * @description :
 **/
public interface LottoTicketsStrategy {
	LottoTickets generate(BuyInfo buyInfo);
}
