package lotto.modal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lotto.util.StringValid;

public class LottoGame {

	private static final String LOTTO_NUMBER_SEPARATOR = ",";

	private LottoResult lottoResult;
	private final Money money;
	private final List<Lotto> lottoPackage;

	public LottoGame(Money userInputMoney) {
		this.money = userInputMoney;
		this.lottoPackage = generateLottoPackage();
	}

	public List<Lotto> getLottoPackage() {
		return this.lottoPackage;
	}

	public void play(String userInputLotto) {
		validationWinnerLotto(userInputLotto);

		this.lottoResult = new LottoResult(lottoPackage, generateWinnerLotto(userInputLotto));
		this.lottoResult.report(money);
	}

	public LottoResult getLottoResult() {
		return this.lottoResult;
	}

	private List<Lotto> generateLottoPackage() {
		List<Lotto> lottoList = new ArrayList<>();
		int count = this.money.getRepeatCount();

		for (int i = 0; i < count; i++) {
			lottoList.add(new Lotto());
		}

		Collections.shuffle(lottoList);
		return lottoList;
	}

	private Lotto generateWinnerLotto(String userInputLotto) {
		return new Lotto(getInputLottoList(userInputLotto));
	}

	private List<LottoNumber> getInputLottoList(String userInputLotto) {
		String[] lottoArray = userInputLotto.replace(" ", "").split(LOTTO_NUMBER_SEPARATOR);
		return Lotto.generateManualLotto(Arrays.asList(lottoArray));
	}

	private void validationWinnerLotto(String userInputLotto) {
		if (StringValid.isEmptyStr(userInputLotto)) {
			throw new IllegalArgumentException("당첨 로또를 입력해주세요.");
		}
	}
}
