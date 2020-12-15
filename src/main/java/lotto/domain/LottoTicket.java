package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class LottoTicket {
	private static final int LOTTO_TICKET_NUMBER_COUNT = 6;
	private Set<LottoNumber> lottoTicketNumbers = new HashSet<>();

	public LottoTicket(List<LottoNumber> lottoNumbers) {
		validateLottoNumbers(lottoNumbers);
		lottoNumbers.stream()
			.forEach(lottoNumber -> addLottoTicketNumber(lottoNumber));
	}

	private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_TICKET_NUMBER_COUNT)
			throw new IllegalArgumentException("로또 번호는 6개를 입력할 수 있습니다.");
	}

	private void addLottoTicketNumber(LottoNumber lottoNumber) {
		if (lottoTicketNumbers.contains(lottoNumber))
			throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
		lottoTicketNumbers.add(lottoNumber);
	}

	public Set<LottoNumber> get() {
		return lottoTicketNumbers;
	}

	@Override
	public String toString() {
		return "LottoTicket{" +
			"lottoTicketNumbers=" + lottoTicketNumbers +
			'}';
	}

	public Long getMatchCount(LottoTicket winnerLottoTicket) {
		Set<LottoNumber> winnerLottoNumbers = winnerLottoTicket.get();
		return lottoTicketNumbers.stream().filter(lottoNumber -> winnerLottoNumbers.contains(lottoNumber))
			.count();
	}
}
