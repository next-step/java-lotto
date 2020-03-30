package lotto.domain;

import lotto.dto.LottoNumbers;
import lotto.dto.PurchasedLottoNumbers;

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

	public PurchasedLottoNumbers buyLottoNumbers(long money) {
		return buyLottoNumbers(money, Collections.emptyList());
	}

	public PurchasedLottoNumbers buyLottoNumbers(long money, List<LottoNumbers> passiveNumbers) {
		long count = money / PRIZE;
		int passiveCount = passiveNumbers.size();
		int autoCount = (int) count - passiveCount;
		return new PurchasedLottoNumbers(passiveCount, autoCount, getLottoNumbers(autoCount, passiveNumbers));
	}

	private List<LottoNumbers> getLottoNumbers(int autoCount, List<LottoNumbers> passiveNumbers) {
		List<LottoNumber> printedLottoNumbers = machinePassive.ticketingLottoNumber(passiveNumbers);
		printedLottoNumbers.addAll(machineAuto.ticketingLottoNumber(autoCount));

		return printedLottoNumbers.stream()
				.map(LottoNumber::getLottoNumbers)
				.collect(Collectors.toList());
	}

}
