package lotto.domain;

import lotto.view.InputView;

import java.util.*;

public class Lotto {

	private static final int LOTTO_NUMBER_MAX_COUNT = 6;

	private static final int TOTAL_LOTTO_NUMBER_MAX = 45;

	private List<Integer> lottoNumbers = new ArrayList<>();

	private static List<Integer> defaultLottoNumbers = new ArrayList<>();

	static {
		for (int i = 0; i < TOTAL_LOTTO_NUMBER_MAX; i++) {
			defaultLottoNumbers.add(i + 1);
		}
	}

	public Lotto() {
	}

	public Lotto(List<Integer> inputNumber) {
		lottoNumbers.addAll(inputNumber);
			lottoNumbers.add(number);
		}
		validateMaxCount(lottoNumbers);
	}

	public List<Integer> getLottoNumbers() {
		return lottoNumbers;
	}

	public List<Integer> getShuffleNumbers() {
		Collections.shuffle(defaultLottoNumbers);
		List<Integer> autoLottos = new ArrayList<>();
		for (int i = 0; i < LOTTO_NUMBER_MAX_COUNT; i++) {
			autoLottos.add(defaultLottoNumbers.get(i));
		}
		return autoLottos;
	}

	public List<Lotto> generateAutoLottoNumbers(int lottoPayCount) {
		List<Lotto> generatedLottos = new ArrayList<>();
		for (int i = 0; i < lottoPayCount; i++) {
			generatedLottos.add(new Lotto(this.getShuffleNumbers()));
		}
		return generatedLottos;
	}

	public int getMatchCount(Lotto lastWeekPrizeNumberList, Lotto generatedLotto) {
		return countMatchNumber(lastWeekPrizeNumberList, generatedLotto);
	}

	public List<Lotto> generatePurchagedAutoLotto(int lottoTryCount) {
		InputView.printPurchaseLottoCount(lottoTryCount);
		List<Lotto> generatedLottos = new ArrayList<>();
		for (int i = 0; i < lottoTryCount; i++) {
			generatedLottos.add(new Lotto(this.getShuffleNumbers()));
			generatedLottos.get(i).toString();
		}

		return generatedLottos;
	}

	public int countMatchNumber(Lotto lastWeekPrizeNumberList, Lotto generatedLotto) {
		return lastWeekPrizeNumberList.countMatchNumber(generatedLotto);
	}

		public int countMatchNumber(Lotto generatedLotto) {
		return (int) this.lottoNumbers.stream()
				.filter(number -> generatedLotto.lottoNumbers.contains(number))
				.count();
	}
		int count = 0;
		for (int number : this.lottoNumbers) {
			count += countMatchNumber(generatedLotto, number);

		}
		return count;
	}

	private int countMatchNumber(Lotto generatedLotto, int number) {
		if (generatedLotto.contains(number)) {
			return 1;
		}
		return 0;
	}

	private boolean contains(int number) {
		return this.lottoNumbers.contains(number);
	}

	private void validateMaxCount(List<Integer> generatedLotto) {
		Set<Integer> validateSet = new HashSet<>(generatedLotto);
		if (validateSet.size() != LOTTO_NUMBER_MAX_COUNT) {
			throw new IllegalArgumentException();
		}
	}

	public boolean isMatchBonusNumber(int bonusNumber) {
		return this.lottoNumbers.contains(bonusNumber);
	}

}
