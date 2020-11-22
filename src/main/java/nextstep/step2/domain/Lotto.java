package nextstep.step2.domain;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
	private static final String WRONG_LOTTO_NUMBERS = "로또 번호는 6개여야 합니다.";
	protected static final int LOTTO_SIZE = 6;
	private Set<LottoNumber> numbers;
	private LottoReward lottoReward;

	public Lotto() {
	}
	public Lotto(Set<LottoNumber> numbers) {
		this.numbers = numbers;
	}

	public Set<LottoNumber> getNumbers() {
		return numbers;
	}

	public void validate() {
		if (numbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException(WRONG_LOTTO_NUMBERS);
		}
	}

	public Lotto getLastWeekLotto(String winnerNumbers) {
		String[] winningNumberSplit = winnerNumbers.replaceAll(" ", "").split(",");
		Set<LottoNumber> winningNumbers =  Stream.of(winningNumberSplit)
				.map(number -> new LottoNumber(LottoNumber.getValidateNumber(number)))
				.collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
		return new Lotto(winningNumbers);
	}

	public void setLottoReward(WinningLotto lotto) {
		long matchCount = getMatchCount(this, lotto.getLastWeekLotto());
		boolean hasBonusNumber = hasBonusNumber(this, lotto.getBonusNumber());
		lottoReward = LottoReward.getReword(Math.toIntExact(matchCount), hasBonusNumber);
	}

	protected boolean hasBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
		return lotto.getNumbers().contains(bonusNumber);
	}

	private long getMatchCount(Lotto lotto, Lotto lastWeekLotto) {
		return lotto.getNumbers().stream()
				.filter(number -> lastWeekLotto.getNumbers().contains(number))
				.count();
	}

	public LottoReward getLottoReward() {
		return lottoReward;
	}
}
