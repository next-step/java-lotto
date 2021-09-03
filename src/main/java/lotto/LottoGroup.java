package lotto;

import java.util.List;

public class LottoGroup {
	private final List<Lotto> lottoGroup;

	public LottoGroup(List<Lotto> lottoNumbers) {
		this.lottoGroup = lottoNumbers;
	}

	public LottoPaper lottoResultReport(Lotto winningNumbers) {
		LottoPaper lottoReport = new LottoPaper();

		for (int i = 0; i < this.lottoGroup.size(); i++) {
			Lotto unknownLotto = lottoGroup.get(i);
			Lotto knownLotto = unknownLotto.unmaskedLotto(winningNumbers);
			lottoReport = knownLotto.write(lottoReport);
		}

		return lottoReport;
	}
}
