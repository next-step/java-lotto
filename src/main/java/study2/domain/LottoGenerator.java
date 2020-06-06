package study2.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

	public static Long generateLottoNumber() {
	  
		 return IntStream.
			range(Lotto.Min_Lotto_number, Lotto.Max_Lotto_number)
			.boxed()
			.collect(Collectors.counting());
	  
	  }
}
