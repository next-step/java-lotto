package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLotto {
	public static final int LOTTO_PRICE = 1000;
	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_MAX_NUMBER = 45;
	private static final int LOTTO_NUMBER_COUNT = 6;
	public static final int[] PRICES = {0, 0, 0, 5000, 50000, 1500000, 2000000000};

	private int lottoCount = 0;
	private List<List<Integer>> lottos = new ArrayList<>();
	private int[] statistics = new int[7];

	public AutoLotto(int money) {
		if (money < LOTTO_PRICE) {
			throw new IllegalArgumentException();
		}

		this.lottoCount = money / LOTTO_PRICE;
	}

	public List<List<Integer>> play() {
		return play(lottoCount);
	}

	public List<List<Integer>> play(int lottoCount) {
		List<Integer> lotto;
		for (int i = 0; i < lottoCount; i++) {
			lotto = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).boxed().collect(Collectors.toList());
			Collections.shuffle(lotto);
			lotto = lotto.subList(0, LOTTO_NUMBER_COUNT);
			Collections.sort(lotto);
			lottos.add(lotto);
		}

		return lottos;
	}

	public void setResult(String resultString) {
		List<Integer> result = Arrays.asList(resultString.replaceAll(" ", "").split(",")).stream()
				.map(s -> Integer.parseInt(s))
				.collect(Collectors.toList());

		makeStatistic(result);
	}

	public void makeStatistic(List<Integer> result) {
		for (List<Integer> lotto : lottos) {
			lotto.retainAll(result);
			statistics[lotto.size()]++;
		}
	}

	public int[] getStatistics() {
		return statistics;
	}
}
