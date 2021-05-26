package lottery;

import java.util.Objects;
import java.util.Set;

public final class Ticket {

	public final static int SIZE_OF_TICKET = 6;
	private LottoNumbers lottoNumbers;

	public static Ticket of(LottoNumbers lottoNumbers) {
		return new Ticket(lottoNumbers);
	}

	private Ticket(LottoNumbers lottoNumbers) {
		setNumbers(lottoNumbers);
	}

	private void setNumbers(LottoNumbers lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public Set<Integer> numbers() {
		return lottoNumbers.getValues();
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
