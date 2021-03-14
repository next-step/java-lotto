package camp.nextcamp.edu.lotto.entity;

public class LottoTicket {
	private final int ticketCount;

	public LottoTicket(int count) {
		this.ticketCount = count;
	}

	public int getTicketCount() {
		return this.ticketCount;
	}
}
