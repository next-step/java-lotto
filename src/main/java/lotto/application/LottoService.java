package lotto.application;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.LottoLotteries;
import lotto.domain.LottoLotteriesFactory;
import lotto.domain.LottoLottery;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoResults;
import lotto.domain.WinLottoNumbers;

public class LottoService {
	private final LottoNumberGenerator lottoNumberGenerator;

	public LottoService(LottoNumberGenerator lottoNumberGenerator) {
		this.lottoNumberGenerator = lottoNumberGenerator;
	}

	public LottoLotteries buyLottoLotteries(List<LottoLottery> manualLottoLotteries, int autoCount) {
		return LottoLotteriesFactory.createLottoLotteries(manualLottoLotteries, buyAutoLottoLotteries(autoCount));
	}

	List<LottoLottery> buyAutoLottoLotteries(int count) {
		return IntStream.range(0, count)
			.mapToObj(value -> new LottoLottery(lottoNumberGenerator.generate()))
			.collect(Collectors.toList());
	}

	public LottoResults checkLottoResults(LottoLotteries lottoLotteries, WinLottoNumbers winLottoNumbers) {
		return lottoLotteries.checkLottoResults(winLottoNumbers);
	}
}
