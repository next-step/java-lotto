package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

	@DisplayName("숫자 그룹에 중복된 숫자는 입력 불가능하다.")
	@Test
	void 중복_테스트() {
		assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(new LottoNumber(4), new LottoNumber(4))))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("중복된 데이터가 있습니다.");
	}

	@DisplayName("숫자 그룹은 최대 6개이다.")
	@Test
	void 로또_최대_번호_테스트() {
		assertThatThrownBy(() -> new LottoNumbers(
			Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(8), new LottoNumber(7))))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("로또 숫자개수는 6을 초과할수 없습니다.");
	}

	@DisplayName("숫자 그룹 자릿수 값 비교 테스트")
	@Test
	void 숫자_그룹_비교_테스트() {
		List<LottoNumber> lottoNumbers1 = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
		List<LottoNumber> lottoNumbers2 = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
		LottoNumbers one = new LottoNumbers(lottoNumbers1);
		LottoNumbers two = new LottoNumbers(lottoNumbers2);
		assertThat(one).isEqualTo(two);
	}
}
