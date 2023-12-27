package lotto.domain;

import java.util.List;

public class Ticket {
	private final List<Lottos> ticket;

	public Ticket(List<Lottos> ticket){
		this.ticket = ticket;
	}

	public List<Lottos> ticket(){
		return ticket;
	}

	public int compareTo(int[] winningNumbers, int index){
		return ticket.get(index).contains(winningNumbers);
	}
}
