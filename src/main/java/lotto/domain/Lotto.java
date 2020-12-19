package lotto.domain;

import lotto.view.InputView;

import java.util.*;

public class Lotto {

	public static final int LOTTO_PRICE_PER_SHEET = 1000;

	private static final int TOTAL_LOTTO_NUMBER_MAX = 45;

	public static List<Integer> defaultLottoNumbers = new ArrayList<>();

	public Lotto() {
		for (int i = 0; i < TOTAL_LOTTO_NUMBER_MAX; i++) {
			this.defaultLottoNumbers.add(i + 1);
		}
	}

	public List<GeneratedLotto> generateAutoLottoNumbers(int lottoCount) {
		List<GeneratedLotto> generatedLottos = new ArrayList<>();
		for (int i = 0; i < lottoCount; i++) {
			GeneratedLotto generatedLotto = new GeneratedLotto();
			generatedLottos.add(generatedLotto);
		}
		return generatedLottos;
	}


	public int getMatchCount(GeneratedLotto lastWeekPrizeNumberList, GeneratedLotto generatedLotto) {
		return GeneratedLotto.countMatchNumber(lastWeekPrizeNumberList, generatedLotto);
	}

	public List<GeneratedLotto> generatePurchagedAutoLotto(int purchaseAmount) {
		int lottoTryCount = calculateLottoCount(purchaseAmount);
		InputView.printPurchaseLottoCount(lottoTryCount);
		List<GeneratedLotto> generatedLottos = this.generateAutoLottoNumbers(lottoTryCount);
		InputView.printLottoNumber(generatedLottos);
		return generatedLottos;
	}

	public int calculateLottoCount(int purchaseAmount) {
		return purchaseAmount / this.LOTTO_PRICE_PER_SHEET;
	}

}
