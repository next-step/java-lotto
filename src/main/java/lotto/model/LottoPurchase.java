package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.service.SearchPrize;
import lotto.utils.Utils;
import lotto.validation.Validation;

public class LottoPurchase {

	public static final int START_INCLUSIVE = 0;
	public static final String LAST_WIN_NUMBER_REGEX = ",";

	private final LottoGames lottoGames;

	public LottoPurchase(int lottoCount) {
		List<LottoGame> lottoCreateGame = new ArrayList<>();
		for (int i = START_INCLUSIVE; i < Utils.returnThousandUnit(lottoCount); i++) {
			lottoCreateGame.add(new LottoGame(LottoMachine.createLottoNumber()));
		}
		lottoGames = new LottoGames(lottoCreateGame);
	}

	public LottoPurchase(LottoGames lottoGames) {
		this.lottoGames = lottoGames;
	}

	public List<LottoGame> resultLottoGame() {
		return lottoGames.getLottoGames();
	}

	public Map<Prize, Integer> confirmWinLottoNumber(String lastWinNumber) {
		Validation.validEmptyCheck(lastWinNumber);
		SearchPrize searchPrize = new SearchPrize();
		return searchPrize.getWinPrizes(lottoGames, getLastWinNumbers(lastWinNumber));
	}

	private List<Integer> getLastWinNumbers(String lastWinNumber) {
		String[] lastWinNumbers = lastWinNumber.split(LAST_WIN_NUMBER_REGEX);
		Validation.validLottoSizeCheck(lastWinNumbers);
		return Arrays.stream(lastWinNumbers)
			.map(this::toInt)
			.collect(Collectors.toList());
	}

	private Integer toInt(String value) {
		Validation.validNumberTypeCheck(value.trim());
		return Integer.parseInt(value.trim());
	}
}
