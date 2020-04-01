package lotto.domain;

import lotto.dto.LottoNumberDto;
import lotto.dto.PurchasedLottoNumbersDto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoBuyer {
	private LottoMachineAuto machineAuto;
	private LottoMachinePassive machinePassive;

	public LottoBuyer() {
		machineAuto = new LottoMachineAuto();
		machinePassive = new LottoMachinePassive();
	}

	public PurchasedLottoNumbersDto buyLottoNumbers(LottoMoney money, List<LottoNumberDto> passiveNumbers) {
		int passiveCount = passiveNumbers.size();
		int autoCount = money.getLottoNumbersCount() - passiveCount;
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
