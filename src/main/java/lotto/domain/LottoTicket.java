package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class LottoTicket {

	public static final int LOTTO_TICKET_NUMBER_COUNT = 6;

	private List<LottoNumber> lottoTicketNumbers = new ArrayList<>();

	public LottoTicket(List<LottoNumber> lottoNumbers) {
		validateLottoNumbers(lottoNumbers);
		convertToLottoTicket(lottoNumbers);
	}

	private void convertToLottoTicket(List<LottoNumber> lottoNumbers) {
		lottoNumbers.forEach(lottoNumber -> addLottoTicketNumber(lottoNumber));
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

	public List<LottoNumber> get() {
		return lottoTicketNumbers;
	}

	@Override
	public String toString() {
		return "LottoTicket{" +
			"lottoTicketNumbers=" + lottoTicketNumbers +
			'}';
	}

	public Long getMatchCount(LottoTicket winnerLottoTicket) {
		List<LottoNumber> winnerLottoNumbers = winnerLottoTicket.lottoTicketNumbers;
		return lottoTicketNumbers.stream().
			filter(lottoNumber -> winnerLottoNumbers.contains(lottoNumber))
			.count();
	}

}
