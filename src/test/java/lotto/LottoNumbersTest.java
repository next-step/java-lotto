package lotto;

import exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import type.LottoRewardType;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;
import static type.LottoExceptionType.WRONG_LOTTO_NUMBER;

class LottoNumbersTest {

	@Test
	@DisplayName("생성자 테스트")
	void constructorTest(){
		assertThatCode(() -> new LottoNumbers(Arrays.asList(1,2,3,4,5,6)))
			.doesNotThrowAnyException();
	}

	@Test
	@DisplayName("생성자(중복값 존재하는) 테스트")
	void constructorTestWithDuplication(){
		assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1,2,3,4,4,6)))
			.isInstanceOf(LottoException.class)
			.hasMessageContaining(WRONG_LOTTO_NUMBER.message());
	}

	@Test
	@DisplayName("필수 Parameter null 인 경우 생성자 테스트")
	void constructorFailedWithNullTest(){
		assertThatThrownBy(()-> new LottoNumbers(null))
			.isInstanceOf(LottoException.class)
			.hasMessageContaining(WRONG_LOTTO_NUMBER.message());
	}

	@Test
	@DisplayName("필수 Parameter empty 인 경우 생성자 테스트")
	void constructorFailedWithEmptyTest(){
		assertThatThrownBy(()-> new LottoNumbers(Collections.emptyList()))
			.isInstanceOf(LottoException.class)
			.hasMessageContaining(WRONG_LOTTO_NUMBER.message());
	}

	@Test
	@DisplayName("숫자 모음끼리의 matches 테스트")
	void matchesTest() {
		LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
		LottoNumbers winningLottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,7,8,9));
		LottoNumber bonusNumber = new LottoNumber(10);

		assertThat(lottoNumbers.result(winningLottoNumbers, bonusNumber))
			.isEqualTo(LottoRewardType.FIFTH);
	}
}
