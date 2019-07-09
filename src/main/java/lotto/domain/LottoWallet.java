package lotto.domain;

import lotto.model.LottoNumberSet;
import lotto.model.WinNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWallet {

	private static final CharSequence NEW_LINE = "\n";

	private List<LottoTicket> tickets;

	public LottoWallet(List<LottoTicket> tickets){
		for(LottoTicket ticket : tickets) {
			this.add(ticket);
		}
	}

	private void add(LottoTicket ticket) {

		if(ticket == null){
			throw new IllegalArgumentException();
		}

		if(tickets == null){
			tickets = new ArrayList<>();
		}

		tickets.add(ticket);
	}

	public int ticketCount() {
		return tickets.size();
	}

	public ResultReport result(WinNumber winNumber) {
		ResultReport report = new ResultReport();

		tickets.stream()
				.forEach(ticket -> {
					report.increment(ticket.checkWin(winNumber));
				});

		return report;
	}

	/**
	 * 지정한 숫자로 만들어진 복권이 있는지 확인해주는 메서드
	 * @param numberSet 숫자셋트
	 * @return 동일한 숫자로 구성된 복권이 있다면 true 반환
	 */
	public boolean containsTicketHasNumbers(LottoNumberSet numberSet) {
		return tickets.contains(LottoTicket.of(numberSet));
	}

	@Override
	public String toString() {
		return tickets.stream()
				.map(LottoTicket::toString)
				.collect(Collectors.joining(NEW_LINE));
	}
}
