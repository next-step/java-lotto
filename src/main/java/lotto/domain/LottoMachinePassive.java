package lotto.domain;

import lotto.dto.LottoNumbers;

import java.util.List;
import java.util.stream.Collectors;

class LottoMachinePassive {

	List<LottoNumber> ticketingLottoNumber(List<LottoNumbers> passiveNumbers) {
		return passiveNumbers.stream()
				.map(LottoNumbers::getNumbers)
				.map(LottoNumber::new)
				.collect(Collectors.toList());
	}

}
