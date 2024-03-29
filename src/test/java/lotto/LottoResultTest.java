package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
	private final WinningNumbers winningNumbers = new WinningNumbers(Set.of(1, 2, 3, 4, 5, 6));
	private static final Lotto twoMatchedLotto = new Lotto(new InputLottoNumberStrategy(List.of(1, 2, 7, 8, 9, 10)));
	private static final Lotto threeMatchedLotto = new Lotto(new InputLottoNumberStrategy(List.of(1, 2, 3, 7, 8, 9)));
	private static final Lotto fourMatchedLotto = new Lotto(new InputLottoNumberStrategy(List.of(1, 2, 3, 4, 8, 9)));
	private static final Lotto fiveMatchedLotto = new Lotto(new InputLottoNumberStrategy(List.of(1, 2, 3, 4, 5, 9)));
	private static final Lotto sixMatchedLotto = new Lotto(new InputLottoNumberStrategy(List.of(1, 2, 3, 4, 5, 6)));

	@ParameterizedTest
	@MethodSource("getLottoNumbersAndExpectedPrize")
	void 로또_1개_수익율_계산(Lotto lotto, int expected) {
		int purchasePrice = 1000;

		LottoResult lottoResult = new LottoResult(winningNumbers, List.of(lotto), purchasePrice);

		assertThat(lottoResult.getRate()).isEqualTo((double) expected / purchasePrice);
	}

	@Test
	void 로또_여러개_수익율_계산() {
		int purchasePrice = 5000;

		LottoResult lottoResult = new LottoResult(winningNumbers,
				List.of(twoMatchedLotto, threeMatchedLotto, fourMatchedLotto, fiveMatchedLotto, sixMatchedLotto),
				purchasePrice);


		assertThat(lottoResult.getRate()).isEqualTo((double) (5000 + 50000 + 1500000 + 2000000000) / purchasePrice);
	}

	private static Stream<Arguments> getLottoNumbersAndExpectedPrize() {
		return Stream.of(
				Arguments.of(twoMatchedLotto, 0)
				, Arguments.of(threeMatchedLotto, 5000)
				, Arguments.of(fourMatchedLotto, 50000)
				, Arguments.of(fiveMatchedLotto, 1500000)
				, Arguments.of(sixMatchedLotto, 2000000000)
		);
	}
}
