package lotto.domain;

import lotto.LottoException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PurchaseStandBy {

	public static final int PRICE_PER_GAME = 1000;
	private static final int ZERO = 0;
	private static final String INPUT_SHOULD_NOT_LESS_THAN_PRICE_PER_GAME = "최소 구입 금액은 %d원 이상입니다.";

	private final int purchasePrice;
	private final List<String[]> manualGameNumbers;
	private final int autoGameCount;

	public PurchaseStandBy(int purchasePrice, List<String[]> manualGameNumbers, int autoGameCount) {
		this.purchasePrice = purchasePrice;
		this.manualGameNumbers = manualGameNumbers;
		this.autoGameCount = autoGameCount;
	}

	public PurchaseStandBy(int purchasePrice, List<String[]> manualGameNumbers) {
		this.purchasePrice = purchasePrice;
		this.manualGameNumbers = manualGameNumbers;
		this.autoGameCount = computeAutoGameCount();
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public int getManualGameCount() {
		return manualGameNumbers.size();
	}

	public int getAutoGameCount() {
		return autoGameCount;
	}

	public LottoGames purchase() {
		return new LottoGames(generateLottoGames());
	}

	private List<LottoGame> generateLottoGames() {
		List<LottoGame> lottoGames = manualGameNumbers.stream()
										.map(LottoGameFactory::getNewManualGame)
										.collect(Collectors.toList());

		List<LottoGame> autoGames = IntStream.range(ZERO, autoGameCount)
										.mapToObj(index -> LottoGameFactory.getNewAutoGame())
										.collect(Collectors.toList());
		lottoGames.addAll(autoGames);
		return lottoGames;
	}

	private int computeAutoGameCount() {
		if (purchasePrice < PRICE_PER_GAME) {
			throw new LottoException(String.format(INPUT_SHOULD_NOT_LESS_THAN_PRICE_PER_GAME, PRICE_PER_GAME));
		}
		return (purchasePrice / PRICE_PER_GAME) - manualGameNumbers.size();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PurchaseStandBy that = (PurchaseStandBy) o;
		return purchasePrice == that.purchasePrice &&
				autoGameCount == that.autoGameCount &&
				manualGameNumbers.equals(that.manualGameNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(purchasePrice, manualGameNumbers, autoGameCount);
	}
}
