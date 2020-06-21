package study3.domain;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

	public static List<Integer> generateLottoNumber() {
		
		return shuffleLottoNumbers(
				IntStream.range(
				Lotto.MIN_LOTTO_NUMBER,
				Lotto.MAX_LOTTO_NUMBER)
				.distinct()
				.boxed()
				.collect(Collectors.toList())
				);
	}

	private static List<Integer> shuffleLottoNumbers(List<Integer> lottos) {
		
		Collections.shuffle(lottos); // 섞기 
		return sortLottoNumber(lottos);
	}
	
	private static List<Integer> sortLottoNumber(List<Integer> lottos){
		
		return  lottos
				.stream()
				.limit(Lottos.Lotto_numbers_size)
				.sorted()
				.collect(Collectors.toList());
				
	}
}
