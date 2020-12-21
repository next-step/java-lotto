package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : byungkyu
 * @date : 2020/12/20
 * @description :
 **/
public class LottoWallet {

	private List<LottoTickets> lottoWallet;

	public LottoWallet(LottoTickets... userLottoTickets) {
		lottoWallet = Arrays.asList(userLottoTickets);
	}

	public List<LottoTickets> getLottoTickets() {
		return lottoWallet;
	}
}
