package lotto;

import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LottoStore {
	static final int LOTTO_PRICE = 1000;

	List<LottoNumbers> sell(int money) {
		validateMoney(money);
		List<LottoNumbers> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < money / LOTTO_PRICE; i++) {
			lottoNumbers.add(generateRandomLottoNumbers());
		}
		return lottoNumbers;
	}

	private static void validateMoney(int money) {
		if (money <= 0) {
			throw new IllegalArgumentException("money is not positive");
		}

		if (money % LOTTO_PRICE > 0) {
			throw new IllegalArgumentException("money change exist");
		}
	}

	static LottoNumbers generateRandomLottoNumbers() {
		List<Integer> uniqueNumbers = createUniqueNumbers();
		uniqueNumbers = shuffle(uniqueNumbers);
		List<LottoNumber> lottoNumberList = pickNumbersUntilLottoSize(uniqueNumbers).stream()
				.map(LottoNumber::new)
				.collect(Collectors.toList());
		return new LottoNumbers(lottoNumberList);
	}

	private static List<Integer> createUniqueNumbers() {
		return IntStream
				.range(LottoNumber.LOTTO_NUMBER_RANGE_INCLUSIVE_MIN, LottoNumber.LOTTO_NUMBER_RANGE_INCLUSIVE_MAX + 1)
				.boxed()
				.collect(Collectors.toList());
	}

	private static List<Integer> shuffle(List<Integer> numbers) {
		List<Integer> shuffleList = new ArrayList<>(numbers);
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
