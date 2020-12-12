package lotto;

import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

	@DisplayName("로또 번호는 1~45까지 생성 가능 하다.")
	@Test
	void 로또_번호_생성_테스트() {
		assertThatThrownBy(() -> LottoNumberGenerator.manual(Arrays.asList(1, 2, 3, 4, 5, 46)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("기준 범위를 초과하였습니다.");
	}

	@DisplayName("로또 티켓에서 로또 번호는 최대 6개이다.")
	@ParameterizedTest
	@MethodSource("createNumbers")
	void 로또_최대_번호_테스트(List<Integer> numbers) {
		assertThatThrownBy(() -> LottoNumberGenerator.manual(numbers)).isInstanceOf(IllegalArgumentException.class).hasMessage("로또 숫자개수는 6을 초과할수 없습니다.");
	}

	public static Stream<Arguments> createNumbers() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
		);
	}

	@DisplayName("순서가 다른 로또 숫자 그룹이 서로 일치하는지 확인")
	@ParameterizedTest
	@MethodSource("sortNumbers")
	void 로또_그룹_일치_TEST(List<Integer> targetList, List<Integer> resultList) {
		LottoNumbers targetLottoNumbers = LottoNumberGenerator.manual(targetList);
		LottoNumbers resultLottoNumbers = LottoNumberGenerator.manual(resultList);
		assertThat(targetLottoNumbers).isEqualTo(resultLottoNumbers);
	}

	public static Stream<Arguments> sortNumbers() {
		return Stream.of(
			Arguments.of(Arrays.asList(2, 1, 4, 3, 6, 5), Arrays.asList(1, 2, 3, 4, 5, 6))
		);
	}
}
