package step2.domain;

import java.util.Arrays;
import java.util.List;

public class Lottos {

	private final List<Lotto> lottos;

	public Lottos(final Lotto... lottos) {
		this(Arrays.asList(lottos));
	}

	public Lottos(final List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public int size() {
		return this.lottos.size();
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public LottoResults result(final LottoNumbers winLottoNumbers, final LottoNumber bonusNumber) {
		validateBonusNumberDuplication(winLottoNumbers, bonusNumber);
		this.lottos.forEach(lotto -> lotto.confirmWinning(winLottoNumbers));
		return new LottoResults(this, bonusNumber);
	}

	private void validateBonusNumberDuplication(final LottoNumbers winLottoNumbers, final LottoNumber bonusNumber) {
		if (winLottoNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException("보너스 볼 숫자는 당첨 번호 숫자와 중복되어선 안됩니다.");
		}
	}

}
