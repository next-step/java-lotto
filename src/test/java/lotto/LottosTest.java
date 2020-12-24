package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottosTest {

	@DisplayName("구입 금액을 로또 금액(1000원)으로 최대 로또 구매 수를 구하는지 확인한다.")
	@ParameterizedTest
	@CsvSource(value = {"10000,10", "1234,1", "0,0"})
	void buyTest(int purchaseAmount, int numOfLotto) {

		Lottos lottos = LottoStore.buy(purchaseAmount);
		assertThat(lottos.size()).isEqualTo(numOfLotto);
	}

	@DisplayName("구입 금액이 0이하일 경우 예외처리를 확인한다.")
	@ParameterizedTest
	@ValueSource(ints = {-1, -100})
	void purchaseAmountLetterThanZeroExceptionTest(int purchaseAmount) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoStore.buy(purchaseAmount));
	}

	@DisplayName("여러 개의 로또들과 대상 로또를 비교하여 정상 결과를 반환하는지 확인한다.")
	@ParameterizedTest
	@MethodSource("provideTwoNumbersAndResult")
	void compareResultTest(List<Integer> source1, List<Integer> source2, List<Integer> target, LottoResults expected) {

		Lotto lotto1 = Lotto.of(source1);
		Lotto lotto2 = Lotto.of(source2);
		Lottos lottos = Lottos.of(Arrays.asList(lotto1, lotto2));

		Lotto targetLotto = Lotto.of(target);
		LottoResults lottoResults = lottos.compareResult(targetLotto);

		assertThat(lottoResults).isEqualTo(expected);
	}

	private static Stream<Arguments> provideTwoNumbersAndResult() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),
				Arrays.asList(1, 2, 3, 4, 5, 7),
				Arrays.asList(1, 2, 3, 4, 5, 6),
				LottoResults.of(Arrays.asList(LottoResult.FIRST, LottoResult.SECOND))),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),
				Arrays.asList(7, 8, 9, 10, 11, 12),
				Arrays.asList(13, 14, 15, 16, 17, 18),
				LottoResults.of(Arrays.asList(LottoResult.NONE, LottoResult.NONE)))
		);
	}
}
