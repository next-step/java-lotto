package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoService {

	private static final int LOTTO_PRICE = 1000;

	private final LottoCollection lottoCollection;
	private final LottoResult lottoResult;
	private final int totalMoney;

	public LottoService(int totalMoney, RandomGenerator random) {
		this.totalMoney = totalMoney;
		this.lottoResult = new LottoResult();
		this.lottoCollection = new LottoCollection(totalMoney / LOTTO_PRICE, random);
	}

	public void drawLotto(String text) {
		String[] winningNumbers = text.split(", ");

		List<Integer> numbers = new ArrayList<>();
		for (String number : winningNumbers) {
			numbers.add(Integer.parseInt(number));
		}

		lottoResult.addRanks(lottoCollection.lottoRanks(new LottoNumber(numbers)));
		lottoResult.calculateTotalWinningMoney();
		lottoResult.calculateReturnRate(totalMoney);
	}

	public Map<LottoRank, Integer> totalWinningStatistics() {
		return lottoResult.totalWinningStatistics();
	}

	public double returnRate() {
		return lottoResult.returnRate();
	}

	public List<LottoNumber> getLottoNumberList() {
		return lottoCollection.getLottoNumberList();
	}
}
