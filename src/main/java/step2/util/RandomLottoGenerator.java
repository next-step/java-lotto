package step2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator{
	private static final List<Integer> lottoNumberList = new ArrayList<>();

	public static RandomLottoGenerator init(){
		IntStream.range(1, 46).forEachOrdered(lottoNumberList::add);
		return new RandomLottoGenerator();
	}

	@Override
	public List<Integer> generating() {
		Collections.shuffle(lottoNumberList);
		List<Integer> subList = lottoNumberList.subList(0, 6);
		Collections.sort(subList);
		return subList;
	}
}
