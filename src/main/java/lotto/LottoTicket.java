package lotto;

import java.util.ArrayList;
import java.util.Arrays;
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

	public LottoTicket(LottoNumber... lottoNumbers) {
		validateLottoNumbers(lottoNumbers);
		Arrays.stream(lottoNumbers).forEach(lottoNumber -> addLottoTicketNumber(lottoNumber));

	}

	private void validateLottoNumbers(LottoNumber[] lottoNumbers) {
		if(lottoNumbers.length != LOTTO_TICKET_NUMBER_COUNT)
			throw new IllegalArgumentException("로또 번호는 6개를 입력할 수 있습니다.");
	}

	private void addLottoTicketNumber(LottoNumber lottoNumber) {
		lottoTicketNumbers.add(lottoNumber);
	}

	public Set<LottoNumber> get() {
		return lottoTicketNumbers;
	}

}
