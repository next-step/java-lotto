package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoWallet {
	List<LottoTicket> tickets;

	int balance;

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
		return balance > 0;
	}

	@Override
	public String toString() {
		return tickets.stream().collect(StringBuilder::new,
				(response, element) -> response.append("\n").append(element),
				(response1, response2) -> response1.append("\n").append(response2.toString()))
				.toString();
	}
}
