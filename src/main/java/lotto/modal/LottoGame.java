package lotto.modal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lotto.util.StringValid;

public class LottoGame {

	public static final String LOTTO_NUMBER_SEPARATOR = ",";
	private final Money money;
	private final List<Lotto> lottoPackage;
	private Lotto winnerLotto;

	private LottoGame() {
		throw new AssertionError();
	}

	public LottoGame(Money userInputMoney) {

		this.money = userInputMoney;
		this.lottoPackage = generateLottoPackage();
	}

	public List<Lotto> getLottoPackage() {

		return this.lottoPackage;
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

	public void start(String userInputLotto) {

		validationWinnerLotto(userInputLotto);

		this.winnerLotto = generateWinnerLotto(userInputLotto);

		for (Lotto lotto : this.lottoPackage) {

			System.out.println(lotto.getMatchCount(winnerLotto));
		}
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
