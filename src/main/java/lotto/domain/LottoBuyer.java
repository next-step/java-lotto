package lotto.domain;

import lotto.dto.LottoNumberDto;
import lotto.dto.PurchasedLottoNumbersDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBuyer {
	private static final int PRIZE = 1000;

	private LottoMachineAuto machineAuto;
	private LottoMachinePassive machinePassive;

	public LottoBuyer() {
		machineAuto = new LottoMachineAuto();
		machinePassive = new LottoMachinePassive();
	}

	public PurchasedLottoNumbersDto buyLottoNumbers(long money, List<LottoNumberDto> passiveNumbers) {
		long count = money / PRIZE;
		int passiveCount = passiveNumbers.size();
		int autoCount = (int) count - passiveCount;
		return new PurchasedLottoNumbersDto(passiveCount, autoCount, getLottoNumbers(autoCount, passiveNumbers));
	}

	private List<LottoNumberDto> getLottoNumbers(int autoCount, List<LottoNumberDto> passiveNumbers) {
		List<LottoNumber> printedLottoNumbers = machinePassive.ticketingLottoNumber(passiveNumbers);
		printedLottoNumbers.addAll(machineAuto.ticketingLottoNumber(autoCount));

		return printedLottoNumbers.stream()
				.map(LottoNumber::getLottoNumbers)
				.collect(Collectors.toList());
	}

}
