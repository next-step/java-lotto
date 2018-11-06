package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by hspark on 06/11/2018.
 */
public class Lotto {

	private LottoMachine lottoMachine;
	private List<LottoTicket> lottoMatchNumberList;

	public Lotto(LottoMachine LottoMachine) {
		this.lottoMachine = lottoMachine;
	}

	public List<LottoTicket> purchaseLottoTickets(int lottoPurchaseAmount) {
		return Collections.unmodifiableList(Arrays.asList());
	}

	public LottoMatchingResult matchNumber(List<Integer> previousWinningNumber) {
		return new LottoMatchingResult();
	}
}
