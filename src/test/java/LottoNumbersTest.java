import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

class LottoNumbersTest {

	@Test
	@DisplayName("생성자 테스트")
	void constructorTest(){
		assertThatCode(() -> new LottoNumbers(Arrays.asList(1,2,3,4)))
			.doesNotThrowAnyException();
	}

	@Test
	@DisplayName("필수 Parameter null 인 경우 생성자 테스트")
	void constructorFailedWithNullTest(){
		assertThatThrownBy(()-> new LottoNumbers(null))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("필수 Parameter empty 인 경우 생성자 테스트")
	void constructorFailedWithEmptyTest(){
		assertThatThrownBy(()-> new LottoNumbers(Collections.emptyList()))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("숫자 모음끼리의 matches 테스트")
	void matchesTest() {
		LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4));
		LottoNumbers target = new LottoNumbers(Arrays.asList(1,2,3));

		assertThat(lottoNumbers.matches(target))
			.isEqualTo(3);
	}
}
