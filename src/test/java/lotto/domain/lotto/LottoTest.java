package lotto.domain.lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class LottoTest {

	@ParameterizedTest
	@CsvSource({"FIRST,1,2,3,4,5,6", "SECOND,2,3,4,5,6,7",
			    "SIXTH,6,7,8,9,10,11", "LOST,7,8,9,10,11,12"})
	void 맞춘_개수에_따라_로또의_결과가_정해진다(LottoPrize expectedLottoPrize, int num1, int num2,
								int num3, int num4, int num5, int num6) {
		// given
		Lotto targetLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));

		// when
		targetLotto.examine(Arrays.asList(num1, num2, num3, num4, num5, num6));

		// then
		assertThat(targetLotto.hasSameStatus(expectedLottoPrize)).isTrue();
	}

}
