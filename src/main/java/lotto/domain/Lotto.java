package lotto.domain;

import java.util.*;

public class Lotto {

	private List<Integer> lottoNumbers = new ArrayList<>();

	private static final int TOTAL_LOTTO_NUMBER_MAX = 45;

	private static final int LOTTO_NUMBER_MAX_COUNT = 6;

	public static List<Integer> defaultLottoNumbers = new ArrayList<>();

	static {
		for (int i = 0; i < TOTAL_LOTTO_NUMBER_MAX; i++) {
			defaultLottoNumbers.add(i + 1);
		}
	}


	public Lotto() {
	}

	public Lotto(List<Integer> inputNumber) {
		lottoNumbers.addAll(inputNumber);
		validateMaxCount(lottoNumbers);
	}

	public List<Integer> getLottoNumbers() {
		return lottoNumbers;
	}

	private List<Integer> getShuffleNumbers() {
		Collections.shuffle(defaultLottoNumbers);
		List<Integer> autoLottos = new ArrayList<>();
		for (int i = 0; i < LOTTO_NUMBER_MAX_COUNT; i++) {
			autoLottos.add(defaultLottoNumbers.get(i));
		}
		return autoLottos;
	}

	public List<Lotto> generateAutoLottoNumbers(int lottoPayCount) {
		List<Lotto> purchasedLottos = new ArrayList<>();
		for (int i = 0; i < lottoPayCount; i++) {
			purchasedLottos.add(new Lotto(this.getShuffleNumbers()));
		}
		return purchasedLottos;
	}

	public int getMatchCount(Lotto lastWeekPrizeNumberList, Lotto purchasedLotto) {
		return countMatchNumber(lastWeekPrizeNumberList, purchasedLotto);
	}

	public List<Lotto> generatePurchagedAutoLotto(int lottoTryCount) {
		List<Lotto> purchasedLottos = new ArrayList<>();
		for (int i = 0; i < lottoTryCount; i++) {
			purchasedLottos.add(new Lotto(this.getShuffleNumbers()));
		}
		return purchasedLottos;
	}

	public int countMatchNumber(Lotto lastWeekPrizeNumberList, Lotto purchasedLotto) {
		return lastWeekPrizeNumberList.countMatchNumber(purchasedLotto);
	}

	public int countMatchNumber(Lotto purchasedLotto) {
		return (int) this.lottoNumbers.stream()
				.filter(number -> purchasedLotto.lottoNumbers.contains(number))
				.count();
	}

	private void validateMaxCount(List<Integer> purchasedLotto) {
		Set<Integer> validateSet = new HashSet<>(purchasedLotto);
		if (validateSet.size() != LOTTO_NUMBER_MAX_COUNT) {
			throw new IllegalArgumentException();
		}
	}

	public boolean isMatchBonusNumber(int bonusNumber) {
		return this.lottoNumbers.contains(bonusNumber);
	}

	@Override
	public String toString() {
		return "" + lottoNumbers;
	}
}
