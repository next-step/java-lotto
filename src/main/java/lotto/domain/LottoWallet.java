package lotto.domain;

import common.NumberElement;
import common.NumberElementCollection;
import lotto.model.WinNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWallet {

	private static final CharSequence NEW_LINE = "\n";

	private static final int EMPTY_BALANCE = 0;

	private List<LottoTicket> tickets;

	private int balance;

	public LottoWallet(List<LottoTicket> tickets, int balance){
		for(LottoTicket ticket : tickets) {
			this.add(ticket);
		}
		this.balance = balance;
	}

	private void add(LottoTicket ticket) {

		if(ticket == null || !ticket.verify()){
			throw new IllegalArgumentException("유효하지 않은 복권은 지갑에 담을 수 없습니다.");
		}

		if(tickets == null){
			tickets = new ArrayList<>();
		}

		tickets.add(ticket);
	}

	public int ticketCount() {
		return tickets.size();
	}

	public boolean hasBalance() {
		return balance > EMPTY_BALANCE;
	}

	@Override
	public String toString() {
		return tickets.stream()
				.map(LottoTicket::toString)
				.collect(Collectors.joining(NEW_LINE));
	}

	public ResultReport result(WinNumber winNumber) {
		ResultReport report = new ResultReport();

		tickets.stream()
				.forEach(ticket -> {
					report.increment(ticket.checkWin(winNumber));
				});

		return report;
	}
}
