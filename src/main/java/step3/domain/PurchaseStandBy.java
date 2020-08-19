package step3.domain;

import step3.LottoException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step3.configuration.LottoConfig.PRICE_PER_GAME;

public class PurchaseStandBy {

	private static final int ZERO = 0;

	private static final String INPUT_SHOULD_NOT_LESS_THAN_PRICE_PER_GAME = "최소 구입 금액은 %d원 이상입니다.";

	private final int purchasePrice;

	private final int numberOfGames;

	public PurchaseStandBy(int purchasePrice) {
		this.purchasePrice = purchasePrice;
		this.numberOfGames = computeNumberOfGames(purchasePrice, PRICE_PER_GAME);
	}

	public PurchaseStandBy(int purchasePrice, int numberOfGames) {
		this.purchasePrice = purchasePrice;
		this.numberOfGames = numberOfGames;
	}

	private int computeNumberOfGames(int purchasePrice, int pricePerGame) {
		if (purchasePrice < pricePerGame) {
			throw new LottoException(String.format(INPUT_SHOULD_NOT_LESS_THAN_PRICE_PER_GAME, pricePerGame));
		}
		return purchasePrice / pricePerGame;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public LottoGames purchase() {
		return new LottoGames(generateLottoGames());
	}

	private List<LottoGame> generateLottoGames() {
		return IntStream.range(ZERO, numberOfGames)
						.mapToObj(index -> LottoGameFactory.getNewLottoGame())
						.collect(Collectors.toList());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PurchaseStandBy that = (PurchaseStandBy) o;
		return purchasePrice == that.purchasePrice &&
				numberOfGames == that.numberOfGames;
	}

	@Override
	public int hashCode() {
		return Objects.hash(purchasePrice, numberOfGames);
	}
}
