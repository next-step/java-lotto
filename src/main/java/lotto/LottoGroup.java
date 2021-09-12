package lotto;

import java.util.List;

public class LottoGroup {
	private final List<Lotto> lottoGroup;

	public LottoGroup(List<Lotto> lottoNumbers) {
		this.lottoGroup = lottoNumbers;
	}

	public LottoPaper lottoResultReport(WinningNumber winningNumbers) {
		LottoPaper lottoReport = new LottoPaper();

		for (Lotto lotto : this.lottoGroup) {
			Lotto knownLotto = winningNumbers.unmaskedLotto(lotto);
			lottoReport = knownLotto.write(lottoReport);
		}

		return lottoReport;
	}
}
