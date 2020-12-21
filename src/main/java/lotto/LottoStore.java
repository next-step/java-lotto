package lotto;

import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import lotto.option.LottoMoney;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStore {

	LottoTicket sell(LottoMoney money) {
		List<LottoNumbers> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < money.getLottoBuyCount(); i++) {
			lottoNumbers.add(generateRandomLottoNumbers());
		}
		return new LottoTicket(lottoNumbers, Collections.emptyList());
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
