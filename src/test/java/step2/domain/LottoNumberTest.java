package step2.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
	@Test
	@DisplayName("로또 번호는 1~45 사이인지 체크하는 테스트")
	public void getLottoStastTest() {
		assertThatThrownBy(() -> {
			LottoNumber lottoNumber = new LottoNumber(46);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("asList() 함수 변환 테스트")
	public void asListStringTest() {
		List<LottoNumber> lottoNumberList = IntStream.rangeClosed(1, 6)
			.mapToObj(LottoNumber::new)
			.collect(Collectors.toList());

		assertThat(LottoNumber.asList("1,2,3,4,5,6"))
			.isEqualTo(lottoNumberList);
	}

	@Test
	@DisplayName("asList() 형식 체크 테스트")
	public void asListThrowTest() {
		assertThatThrownBy(() -> {
			LottoNumber.asList("1,2,3,4,5,a");
		}).isInstanceOf(IllegalArgumentException.class);
	}
}