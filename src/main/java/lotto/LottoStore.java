package lotto;

import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStore {
	public static final int LOTTO_PRICE = 1000;

	LottoTicket sell(int money) {
		validateMoney(money);
		List<LottoNumbers> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < money / LOTTO_PRICE; i++) {
			lottoNumbers.add(generateRandomLottoNumbers());
		}
		return new LottoTicket(lottoNumbers);
	}

	private static void validateMoney(int money) {
		if (money <= 0) {
			throw new IllegalArgumentException("money is not positive");
		}

		if (money % LOTTO_PRICE > 0) {
			throw new IllegalArgumentException("money change exist");
		}
	}

	private static LottoNumbers generateRandomLottoNumbers() {
		List<Integer> shuffledNumberList = createShuffledLottoNumberList();
		List<LottoNumber> lottoNumberList = pickNumbersUntilLottoSize(shuffledNumberList)
				.stream()
				.map(LottoNumber::new)
				.collect(Collectors.toList());
		return new LottoNumbers(lottoNumberList);
	}

	private static List<Integer> createShuffledLottoNumberList() {
		List<Integer> shuffleList = new ArrayList<>(LottoNumber.LOTTO_NUMBER_LIST);
		Collections.shuffle(shuffleList);
		return shuffleList;
	}

	private static List<Integer> pickNumbersUntilLottoSize(List<Integer> pickTargets) {
		List<Integer> pickedList = new ArrayList<>();
		for (int i = 0; i < LottoNumbers.LOTTO_NUMBER_SIZE; i++) {
			Integer picked = pickTargets.get(i);
			pickedList.add(picked);
		}
		return pickedList;
	}
}
