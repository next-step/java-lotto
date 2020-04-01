package lotto.domain;

import lotto.dto.PurchasedLottoNumbersDto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoBuyer {

	private final List<LottoNumber> passiveNumbers;
	private final LottoMachine lottoMachine;

	public LottoBuyer(List<LottoNumber> passiveNumbers) {
		this.passiveNumbers = passiveNumbers;
		lottoMachine = new LottoMachine();
	}

	public PurchasedLottoNumbersDto buyLottoNumbers(LottoMoney money) {
		int autoCount = getAutoCount(money);
		if (autoCount < 0) {
			throw new IllegalArgumentException(String.format("buyLottoNumbers failed. please add money more then passiveNumbers" +
					"money=%s, count of passiveNumbers=%d", money, passiveNumbers.size()));
		}
		return getLottoNumbers(autoCount);
	}

	private int getAutoCount(LottoMoney money) {
		return money.getLottoNumbersCount() - passiveNumbers.size();
	}

	private PurchasedLottoNumbersDto getLottoNumbers(int autoCount) {
		List<LottoNumber> printedLottoNumbers = lottoMachine.autoTicketingLottoNumber(autoCount);
		printedLottoNumbers.addAll(passiveNumbers);

		return new PurchasedLottoNumbersDto(
				passiveNumbers.size(),
				autoCount,
				printedLottoNumbers.stream()
						.map(LottoNumber::getLottoNumbers)
						.collect(Collectors.toList()));
	}

}
