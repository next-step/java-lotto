package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
	@Test
	void generateLottoNumbers() {
		List<Integer> expectedLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
		Lotto lotto = new Lotto(expectedLottoNumbers);

		List<Integer> lottoNumbers = lotto.lottoNumbers();

		assertThat(lottoNumbers).isEqualTo(expectedLottoNumbers);
	}
}
