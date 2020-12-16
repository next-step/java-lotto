package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class LottoTest {

	@Test
	void initManualLottoTest() {
		List<String> inputStr = Arrays.asList("1", "3", "23", "34", "37", "45");

		List<LottoNumber> lottoList = inputStr.stream()
			.map(s -> new LottoNumber(Integer.parseInt(s)))
			.collect(Collectors.toList());

		Lotto lotto = new Lotto(lottoList);

		assertThat(lotto).isEqualTo(new Lotto(lottoList));
	}

	@Test
	void initRandomLottoTest() {
		Lotto lotto = new Lotto();
		lotto.getLotto()
			.forEach(System.out::println);

		assertThat(lotto).isNotNull();
	}
}
