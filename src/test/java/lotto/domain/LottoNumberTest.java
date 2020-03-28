package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

	@Test
	void isEqualTest() {
		assertThat(new LottoNumber(1, 2, 3, 4, 5, 6))
				.isEqualTo(new LottoNumber(1, 2, 3, 4, 5, 6));
	}

	@Test
	@DisplayName("객체 생성 유효성 테스트")
	void expectConstructorException(){
		assertThatThrownBy(()->new LottoNumber(1))
				.isInstanceOf(RuntimeException.class);

		assertThatThrownBy(()->new LottoNumber(1,2,3,4,5,5))
				.isInstanceOf(RuntimeException.class);
	}

}