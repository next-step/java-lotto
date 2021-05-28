package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoStore {

	public static final int PRICE = 1000;

	private static final LottoMachine lottoMachine = new LottoMachine();

	public UserLotto buy(LottoBuyingRequest lottoBuyingRequest) {
		return new UserLotto(Collections.unmodifiableList(generateLottoTickets(lottoBuyingRequest)));
	}

	private List<LottoTicket> generateLottoTickets(LottoBuyingRequest lottoBuyingRequest) {
		List<LottoTicket> lottoTicketList = new ArrayList<>(generateManualLottoTickets(lottoBuyingRequest));
		lottoTicketList.addAll(generateAutoLottoIfRequestExist(lottoBuyingRequest.autoLottoCount()));

		return lottoTicketList;
	}

	private List<LottoTicket> generateManualLottoTickets(LottoBuyingRequest lottoBuyingRequest) {
		return lottoMachine.manual(lottoBuyingRequest.manualLottoNumberStrings());
	}

	private List<LottoTicket> generateAutoLottoIfRequestExist(int count) {
		return new ArrayList<>(lottoMachine.generate(count));
	}
}
