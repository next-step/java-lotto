package lotto.domain.lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class LottoTest {

	@ParameterizedTest
	@CsvSource({"FIRST,1,2,3,4,5,6,7", "SECOND,2,3,4,5,6,7,8",
			    "SIXTH,6,7,8,9,10,11,12", "LOST,7,8,9,10,11,12,13",
	            "SECOND_BONUS,1,2,3,4,5,7,6"})
	void 맞춘_개수에_따라_로또의_결과가_정해진다(LottoPrize expectedLottoPrize, int num1, int num2,
								int num3, int num4, int num5, int num6, int bonusNumber) {
		// given
		Lotto targetLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));

		// when
		LottoPrize lottoPrize = targetLotto.examine(Arrays.asList(num1, num2, num3, num4, num5, num6), bonusNumber);

		// then
		assertThat(lottoPrize).isEqualTo(expectedLottoPrize);
	}

}
