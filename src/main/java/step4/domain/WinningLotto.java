package step4.domain;

public class WinningLotto {
	private static final String DUPLICATE_BONUS_NUMBER_PHRASES = "로또 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

	private final Lotto lotto;
	private final LottoNumber bonusNumber;

	public WinningLotto(Lotto lotto, int bonusNumber) {
		validBonusNumber(lotto, bonusNumber);
		this.lotto = lotto;
		this.bonusNumber = new LottoNumber(bonusNumber);
	}

	public Rank getMatchRank(Lotto otherLotto) {
		int count = otherLotto.getMatchCount(lotto);
		boolean isBonus = otherLotto.containNumber(bonusNumber);
		return Rank.valueOf(count, isBonus);
	}

	private void validBonusNumber(Lotto lotto, int bonusNumber) {
		if (lotto.containNumber(new LottoNumber(bonusNumber))) {
			throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_PHRASES);
		}
	}
}
