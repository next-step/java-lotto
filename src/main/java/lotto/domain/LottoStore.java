package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoStore {

	public static final int PRICE = 1000;

	private static final LottoMachine lottoMachine = new LottoMachine();

	public UserLotto buy(LottoBuyingRequest lottoBuyingRequest) {
		List<String> lottoNumberStrings = lottoBuyingRequest.manualLottoNumberStrings();
		List<LottoTicket> lottoTicketList = new ArrayList<>(lottoMachine.manual(lottoNumberStrings));

		if (lottoBuyingRequest.hasAutoLottoRequest()) {
			lottoTicketList.addAll(lottoMachine.generate(lottoBuyingRequest.autoLottoCount()));
		}

		return new UserLotto(Collections.unmodifiableList(lottoTicketList));
	}
}
