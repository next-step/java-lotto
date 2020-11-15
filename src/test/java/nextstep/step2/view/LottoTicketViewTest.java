package nextstep.step2.view;

import nextstep.step2.domain.Lotto;
import nextstep.step2.domain.LottoAutoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LottoTicketViewTest {
	@Test
	@DisplayName("로또 티켓을 출력한다.")
	public void lottoTicketPrintTest() {
		LottoTicketView ticket = new LottoTicketView(getMockLottos());
		ticket.printLottoTickets();
	}

	private List<Lotto> getMockLottos() {
		Lotto lotto1 = new Lotto(new LottoAutoGenerator());
		Lotto lotto2 = new Lotto(new LottoAutoGenerator());
		return Arrays.asList(lotto1,lotto2);
	}
}
