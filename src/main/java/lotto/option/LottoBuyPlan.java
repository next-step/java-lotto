package lotto.option;

import lotto.number.LottoNumbers;

import java.util.List;

public class LottoBuyPlan {
	private static final String VALIDATE_FAIL_MSG =
			"manualNumbers' size must be equal or low than lottoMoney.buyCount!";
	private final LottoMoney lottoMoney;
	private final List<LottoNumbers> manualNumbers;

	public LottoBuyPlan(long money, List<LottoNumbers> manualNumbers) {
		this(new LottoMoney(money), manualNumbers);
	}

	private LottoBuyPlan(LottoMoney lottoMoney, List<LottoNumbers> manualNumbers) {
		validate(lottoMoney, manualNumbers);
		this.lottoMoney = lottoMoney;
		this.manualNumbers = manualNumbers;
	}

	private static void validate(LottoMoney lottoMoney, List<LottoNumbers> manualNumbers)
			throws IllegalArgumentException{
		if (lottoMoney.getLottoBuyCount() < manualNumbers.size()) {
			throw new IllegalArgumentException(VALIDATE_FAIL_MSG);
		}
	}

	public List<LottoNumbers> getManualNumbers() {
		return this.manualNumbers;
	}

	public long getAutoCount() {
		return this.lottoMoney.getLottoBuyCount() - this.manualNumbers.size();
	}
}
