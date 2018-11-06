package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

	public static final int LOTTO_PRICE = 1000;
	public static final int LOTTO_MIN_NUMBER = 1;
	public static final int LOTTO_MAX_NUMBER = 45;
	public static final int PICK_COUNT = 6;

	private int money;
	private List<Integer> numbers;

	public LottoMachine(int money) {
		if(money < LOTTO_PRICE) {
			throw new IllegalArgumentException("1개 이상부터 구매 가능합니다.");
		}
		this.money = money;
		this.numbers = createNumbers();
	}

	private List<Integer> createNumbers() {
		return IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
				.boxed()
				.collect(Collectors.toList());
	}

	public LottoTicket getLottos() {
		int lottoCount = getLottoCount(money);
		List<Lotto> lottos = new ArrayList<>();
		for(int count = 1; count <= lottoCount; count++) {
			lottos.add(getLotto());
		}
		return new LottoTicket(lottos);
	}

	private int getLottoCount(int money) {
		return money / LOTTO_PRICE;
	}

	private Lotto getLotto() {
		List<Integer> pickedNumbers = pick();
		return new Lotto(pickedNumbers);
	}

	private List<Integer> pick() {
		Collections.shuffle(numbers);
		return numbers.stream()
				.limit(PICK_COUNT)
				.collect(Collectors.toList());
	}
}
