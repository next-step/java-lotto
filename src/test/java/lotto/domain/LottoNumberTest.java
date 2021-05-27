package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

	@DisplayName("로또 번호 객체 비교 테스트")
	@Test
	void equals() {
		// given
		int number = 1;

		// then
		LottoNumber actual = LottoNumber.of(number);

		// then
		assertThat(actual).isEqualTo(LottoNumber.of(number));
		assertThat(actual.equals(LottoNumber.of(number))).isTrue();
	}

	@DisplayName("로또 번호 정렬 테스트")
	@Test
	void sort() {
		// given
		List<LottoNumber> lottoNumberList = new ArrayList<>();
		lottoNumberList.add(LottoNumber.of(5));
		lottoNumberList.add(LottoNumber.of(2));
		lottoNumberList.add(LottoNumber.of(3));
		lottoNumberList.add(LottoNumber.of(1));
		lottoNumberList.add(LottoNumber.of(6));
		lottoNumberList.add(LottoNumber.of(4));

		// when
		Collections.sort(lottoNumberList);

		// then
		assertThat(lottoNumberList).containsExactly(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
			LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
	}

	@DisplayName("유효성 체크 테스트")
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 46})
	void invalid(int number) {
		// when
		Throwable throwable = catchThrowable(() -> LottoNumber.of(number));

		// then
		assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
	}

}
