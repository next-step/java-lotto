package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersGroupTest {

	@Test
	@DisplayName("0개 이상의 LottoNumbers 로 LottoNumbersGroup 을 만들 수 있다.")
	public void createLottoNumbersGroupTest() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		LottoNumbers lottoNumbers = new LottoNumbers(numbers);

		LottoNumbersGroup lottoNumbersGroup = new LottoNumbersGroup(Arrays.asList(lottoNumbers));

		assertThat(lottoNumbersGroup.getLottoNumbersGroup()).containsExactly(numbers);
	}
}
