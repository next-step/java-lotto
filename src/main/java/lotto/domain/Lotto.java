package lotto.domain;

import lotto.domain.input.LottoBuyCount;
import lotto.domain.result.HasBonusNumber;
import lotto.domain.result.MatchCount;

import java.util.*;

public class Lotto {

	private List<LottoNumber> lottoNumbers = new ArrayList<>();

	private static final int LOTTO_NUMBER_MAX_COUNT = 6;

	public Lotto() {
	}

	public Lotto(List<LottoNumber> inputNumber) {
		lottoNumbers.addAll(inputNumber);
		validateMaxCount(lottoNumbers);
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}

	private List<LottoNumber> getShuffleNumbers() {
		List<LottoNumber> autoLottos = new ArrayList<>();
		for (int i = 0; i < LOTTO_NUMBER_MAX_COUNT; i++) {
			autoLottos.add(new LottoNumber());
		}
		return autoLottos;
	}

	public MatchCount getMatchCount(Lotto lastWeekPrizeNumberList, Lotto purchasedLotto) {
		return countMatchNumber(lastWeekPrizeNumberList, purchasedLotto);
	}

	public LottoList generateAutoLotto(LottoBuyCount autoLottoCount, LottoList lottoList) {
		for (int i = 0; i < autoLottoCount.getLottoBuyCount(); i++) {
			lottoList.add(new Lotto(this.getShuffleNumbers()));
		}
		return lottoList;
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
		return "" + lottoNumbers;
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
