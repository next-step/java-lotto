package step3.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {

	private static final int RANGE_START = 1;
	private static final int RANGE_END = 46;
	private static final int SUBLIST_START = 0;
	private static final int SUBLIST_END = 6;

	private static final List<Integer> lottoNumberList = new ArrayList<>();

	static {
		IntStream.range(RANGE_START, RANGE_END).forEachOrdered(lottoNumberList::add);
	}

	@Override
	public List<Integer> generating() {
		Collections.shuffle(lottoNumberList);
		List<Integer> subList = new ArrayList<>(lottoNumberList.subList(SUBLIST_START, SUBLIST_END));
		Collections.sort(subList);
		return subList;
	}
}
