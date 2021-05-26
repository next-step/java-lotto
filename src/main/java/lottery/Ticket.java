package lottery;

import java.util.Objects;
import java.util.Set;

public final class Ticket {

	public final static int SIZE_OF_TICKET = 6;
	private LottoNumbers lottoNumbers;
	private TicketType type;

	public static Ticket of(LottoNumbers lottoNumbers, TicketType type) {
		return new Ticket(lottoNumbers,type);
	}

	private Ticket(LottoNumbers lottoNumbers, TicketType type) {
		setNumbers(lottoNumbers);
		setType(type);
	}

	private void setType(TicketType type) {
		if (Objects.isNull(type)){
			throw new IllegalArgumentException("로또 티켓 타입을 찾을 수 없습니다");
		}
		this.type = type;
	}

	private void setNumbers(LottoNumbers lottoNumbers) {
		if (Objects.isNull(lottoNumbers)){
			throw new IllegalArgumentException("로또 번호를 찾을 수 없습니다");
		}
		this.lottoNumbers = lottoNumbers;
	}

	public Set<LottoNo> numbers() {
		return lottoNumbers.values();
	}

	public TicketType getType() {
		return type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Ticket))
			return false;
		Ticket ticket = (Ticket)o;
		return Objects.equals(lottoNumbers, ticket.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}
}
