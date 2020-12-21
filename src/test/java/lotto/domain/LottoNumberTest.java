package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {
	LottoNumber lottoNumber = new LottoNumber();

	@DisplayName("로또 번호 생성 테스트")
	@Test
	public void generateLottoNumberTest() {
		List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		lottoNumber.generate(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
		List<Integer> actual = this.lottoNumber.getLottoNumber();
		assertThat(expected).isEqualTo(actual);
	}
}
