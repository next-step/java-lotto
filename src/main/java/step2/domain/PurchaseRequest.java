package step2.domain;

import step2.LottoException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step2.configuration.LottoConfig.PRICE_PER_GAME;

public class PurchaseRequest {

	private static final int ZERO = 0;

	private static final String PRICE_PER_GAME_SHOULD_OVER_ZERO = "로또 게임당 가격은 0원보다 비싸야 합니다.";

	private final int purchasePrice;

	private final int numberOfGames;

	public PurchaseRequest(int purchasePrice) {
		this.purchasePrice = purchasePrice;
		this.numberOfGames = computeNumberOfGames(purchasePrice, PRICE_PER_GAME);
	}

	public PurchaseRequest(int purchasePrice, int numberOfGames) {
		this.purchasePrice = purchasePrice;
		this.numberOfGames = numberOfGames;
	}

	private int computeNumberOfGames(int purchasePrice, int pricePerGame) {
		if(pricePerGame <= ZERO) {
			throw new LottoException(PRICE_PER_GAME_SHOULD_OVER_ZERO);
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
		return IntStream.range(ZERO,numberOfGames)
						.mapToObj(index -> LottoGameFactory.getNewLottoGame())
						.collect(Collectors.toList());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PurchaseRequest that = (PurchaseRequest) o;
		return purchasePrice == that.purchasePrice &&
				numberOfGames == that.numberOfGames;
	}

	@Override
	public int hashCode() {
		return Objects.hash(purchasePrice, numberOfGames);
	}
}
