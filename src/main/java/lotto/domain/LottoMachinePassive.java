package lotto.domain;

import lotto.dto.LottoNumberDto;

import java.util.List;
import java.util.stream.Collectors;

class LottoMachinePassive {

	List<LottoNumber> ticketingLottoNumber(List<LottoNumberDto> passiveNumbers) {
		return passiveNumbers.stream()
				.map(LottoNumberDto::getNumbers)
				.map(LottoNumber::new)
				.collect(Collectors.toList());
	}

}
