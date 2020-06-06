package study2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

	public static List<Integer> generateLottoNumber() {
		
		return shuffleLottoNumbers(
				IntStream.range(
				Lotto.Min_Lotto_number,
				Lotto.Max_Lotto_number)
				.distinct()
				.boxed()
				.collect(Collectors.toList())
				);

	}

	private static List<Integer> shuffleLottoNumbers(List<Integer> lottoNumbers) {
		
		Collections.shuffle(lottoNumbers); // 이부분을 주석처리하면 왜 정상적으로 실행되지 않는지 이해가 되지를 않습니다.
		return sortLottoNumber(lottoNumbers);
	}
	
	private static List<Integer> sortLottoNumber(List<Integer> lottoNumbers){
		
		return  lottoNumbers
				.stream()
				.limit(LottoNumbers.Lotto_numbers_size)
				.sorted()
				.collect(Collectors.toList());
				
	}
	

}
