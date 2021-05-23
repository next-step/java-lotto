package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LottoMachine {

	List<LottoTicket> generate(int count) {
		List<LottoTicket> lottoTicketList = new ArrayList<>(count);

		for (int i = 0; i < count; i++) {
			lottoTicketList.add(LottoNumberPool.generate());
		}

		return Collections.unmodifiableList(lottoTicketList);
	}

}
