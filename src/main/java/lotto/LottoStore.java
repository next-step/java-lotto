package lotto;

import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import lotto.option.LottoBuyPlan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class LottoStore {

	LottoTicket sell(LottoBuyPlan buyPlan) {
		List<LottoNumbers> autoNumberList = new ArrayList<>();
		for (long i = 0; i < buyPlan.getAutoCount(); i++) {
			autoNumberList.add(generateRandomLottoNumbers());
		}
		return new LottoTicket(buyPlan.getLottoMoney(), autoNumberList, buyPlan.getManualNumbers());
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
