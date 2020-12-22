package lotto.option;

import lotto.number.LottoNumbers;

import java.util.Collections;
import java.util.List;

public class LottoBuyPlan {
	private static final String VALIDATE_FAIL_SIZE_OVER = "manualNumbersSize cannot be over than lottoBuyCount!";
	private static final String VALIDATE_FAIL_NEGATIVE = "manualNumbersSize cannot be negative!";
	private final LottoMoney lottoMoney;
	private final List<LottoNumbers> manualNumbers;

	public LottoBuyPlan(long money, List<LottoNumbers> manualNumbers) {
		this(new LottoMoney(money), manualNumbers);
	}

	public LottoBuyPlan(LottoMoney lottoMoney, List<LottoNumbers> manualNumbers) {
		validate(lottoMoney, manualNumbers);
		this.lottoMoney = lottoMoney;
		this.manualNumbers = Collections.unmodifiableList(manualNumbers);
	}

	private static void validate(LottoMoney lottoMoney, List<LottoNumbers> manualNumbers) {
		validate(lottoMoney, manualNumbers.size());
	}

	public static void validate(LottoMoney lottoMoney, long manualNumbersSize) throws IllegalArgumentException {
		if (manualNumbersSize < 0) {
			throw new IllegalArgumentException(VALIDATE_FAIL_NEGATIVE);
		}

		if (lottoMoney.getLottoBuyCount() < manualNumbersSize) {
			throw new IllegalArgumentException(VALIDATE_FAIL_SIZE_OVER);
		}
	}

	public LottoMoney getLottoMoney() {
		return lottoMoney;
	}

	public List<LottoNumbers> getManualNumbers() {
		return this.manualNumbers;
	}

	public long getAutoCount() {
		return this.lottoMoney.getLottoBuyCount() - this.manualNumbers.size();
	}
}
