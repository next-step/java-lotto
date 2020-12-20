package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : byungkyu
 * @date : 2020/12/20
 * @description :
 **/
public class LottoWallet {

	private List<LottoTickets> lottoWallet;

	public LottoWallet(LottoTickets... userLottoTickets) {
		lottoWallet = splitUserLottoTickets(userLottoTickets);
	}

	private List<LottoTickets> splitUserLottoTickets(LottoTickets[] userLottoTickets) {
		lottoWallet = new ArrayList<>();
		for (LottoTickets lottoTickets : userLottoTickets) {
			lottoWallet.add(lottoTickets);
		}
		return lottoWallet;
	}

	public List<LottoTickets> getLottoTickets() {
		return lottoWallet;
	}
}
