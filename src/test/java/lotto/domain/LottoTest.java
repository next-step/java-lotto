package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.enums.Rank;
import lotto.exception.LottoValidationException;

class LottoTest {

	private final List<Integer> buyNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

	@Test
	@DisplayName("원하는 숫자로 로또 번호가 생성이 되었는가")
	void generateDesiredLottoNumber() {
		Lotto lotto = Lotto.of(buyNumbers);

		assertThat(lotto.equals(Lotto.of(buyNumbers))).isTrue();
	}

	@ParameterizedTest
	@MethodSource("provideLottoList")
	@DisplayName("당첨 번호와 3개 동일하면 5등")
	void figureOutRank(List<Integer> lottoNumbers, boolean expected) {
		Lotto buyLotto = Lotto.of(buyNumbers);
		WinLotto winningLotto = WinLotto.of(lottoNumbers, 45);

		assertThat(buyLotto.figureOutRank(winningLotto).equals(Rank.FIFTH)).isEqualTo(expected);
	}

	private static Stream<Arguments> provideLottoList() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3, 8, 9, 10), true),
			Arguments.of(Arrays.asList(1, 2, 15, 8, 9, 10), false),
			Arguments.of(Arrays.asList(11, 13, 25, 18, 9, 10), false),
			Arguments.of(Arrays.asList(10, 2, 3, 8, 9, 6), true)
		);
	}

	@Test
	@DisplayName("당첨 번호와 5개 동일하고 보너스 번호를 가지고 있으면 2등")
	void figureOutRankTop2() {
		Lotto buyLotto = Lotto.of(buyNumbers);
		WinLotto winningLotto = WinLotto.of(Arrays.asList(1, 2, 3, 4, 5, 16), 6);

		assertThat(buyLotto.figureOutRank(winningLotto)).isEqualTo(Rank.SECOND);
	}

	@Test
	@DisplayName("로또 번호가 8개 경우 예외 테스트")
	void validLottoNumbersLength() {
		assertThatExceptionOfType(LottoValidationException.class)
			.isThrownBy(() -> {
				Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
			}).withMessage("로또 번호는 6개의 숫자여야 합니다.");
	}
}