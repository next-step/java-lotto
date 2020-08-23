package step3;

import step3.domain.Lotto;
import step3.domain.LottoNumber;
import step3.domain.LottoStatistic;
import step3.domain.LottoWinning;
import step3.view.InputView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class LottoResult {
	private final List<Lotto> issueLottos;
	private LottoStatistic statistic;

	private static final int LOTTO_PRICE = 1000;
	private static final String DUPLICATE_BONUS_NUMBER_PHRASES = "로또 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
	private static final String BONUS_NUMBER_RANGE_PHRASES = "로또 보너스 번호는 1~45 중 한 개의 숫자로 이루어져야 합니다.";

	public LottoResult(List<Lotto> issueLottos) {
		this.issueLottos = issueLottos;
	}

	public Map<LottoWinning, Integer> getGameResult() {
		Lotto winningLotto = InputView.inputWinningNumbers();
		int bonusNumber = InputView.inputBonusBall();
		validBonusNumber(winningLotto, bonusNumber);

		statistic = new LottoStatistic(winningLotto, bonusNumber);
		return statistic.calcLottoResult(issueLottos);
	}

	private void validBonusNumber(Lotto winningLotto, int bonusNumber) {
		if (winningLotto.containNumber(new LottoNumber(bonusNumber))) {
			throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_PHRASES);
		}
		if (bonusNumber > LottoNumber.MAX_LOTTO_VALUE) {
			throw new IllegalArgumentException(BONUS_NUMBER_RANGE_PHRASES);
		}
	}

	public BigDecimal getGameStatistic() {
		return statistic.calcYield(issueLottos.size()*LOTTO_PRICE);
	}

}
