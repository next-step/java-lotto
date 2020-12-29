package lotto.domain;

import lotto.domain.result.HasBonusNumber;
import lotto.domain.result.MatchCount;

import java.util.*;

public class Lotto {

	private static final int LOTTO_NUMBER_MAX_COUNT = 6;

	private List<LottoNumber> lottoNumbers = new ArrayList<>();

	public Lotto(List<LottoNumber> inputNumber) {
		lottoNumbers.addAll(inputNumber);
		validateMaxCount(lottoNumbers);
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}

	public static List<LottoNumber> getShuffleNumbers() {
		Set<LottoNumber> autoLottos = new HashSet<>();
		do {
			autoLottos.add(new LottoNumber());
		} while (autoLottos.size() < LOTTO_NUMBER_MAX_COUNT);
		return new ArrayList<>(autoLottos);
	}

	public MatchCount getMatchCount(Lotto lastWeekPrizeNumberList, Lotto purchasedLotto) {
		return countMatchNumber(lastWeekPrizeNumberList, purchasedLotto);
	}

	public MatchCount countMatchNumber(Lotto lastWeekPrizeNumberList, Lotto purchasedLotto) {
		return lastWeekPrizeNumberList.countMatchNumber(purchasedLotto);
	}

	public MatchCount countMatchNumber(Lotto purchasedLotto) {
		return
				new MatchCount((int) this.lottoNumbers.stream()
				.filter(number -> purchasedLotto.getLottoNumbers().contains(number))
				.count());
	}

	private void validateMaxCount(List<LottoNumber> purchasedLotto) {
		Set<LottoNumber> validateSet = new HashSet<>(purchasedLotto);
		if (validateSet.size() != LOTTO_NUMBER_MAX_COUNT) {
			throw new IllegalArgumentException();
		}
	}

	public HasBonusNumber isMatchBonusNumber(LottoNumber bonusNumber) {
		return new HasBonusNumber(this.lottoNumbers.contains(bonusNumber));
	}

	@Override
	public String toString() {
		return "" + lottoNumbers.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Lotto lotto = (Lotto) o;
		return Objects.equals(lottoNumbers, lotto.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}
}
