package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
	private static final int LOTTO_START_NUMBER = 1;
	private static final int LOTTO_END_NUMBER = 45;

	private final List<Integer> lotto;

	public Lotto(List<Integer> lotto) {
		validateLotto(lotto);
		this.lotto = lotto;
	}

	private void validateLotto(List<Integer> lotto) {
		if (lotto == null) {
			throw new IllegalArgumentException("로또 번호를 입력하지 않았습니다.");
		}

		boolean isValid = lotto.stream()
			.anyMatch(number -> number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER);
		if (isValid) {
			throw new IllegalArgumentException("1부터 45사이 번호만 입력 가능합니다.");
		}
	}

	public List<Integer> getLotto() {
		return lotto;
	}

	protected int match(Lotto winLotto) {
		return (int) lotto.stream()
			.filter(winLotto.lotto::contains)
			.count();
	}

	public LottoRank rankLotto(Lotto winLottoNumber) {
		int sameNumberCount = match(winLottoNumber);
		return LottoRank.valueOfCount(sameNumberCount);
	}

	@Override
	public String toString() {
		return "["+lotto.stream().map(lotto -> Integer.toString(lotto)).collect(Collectors.joining(", "))+"]";
	}
}
