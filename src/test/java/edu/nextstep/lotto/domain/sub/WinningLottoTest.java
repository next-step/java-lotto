package edu.nextstep.lotto.domain.sub;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("WinningLotto: 1등 당첨번호와 보너스 번호를 인스턴스 변수로 하는 포장 클래스")
class WinningLottoTest {

	@DisplayName("생성자: 보너스 번호가 1등 당첨번호에 포함되어 있으면 예외를 발생시킨다")
	@ParameterizedTest
	@ValueSource(ints = {-1, 6, 46})
	void generator_shouldException(int bonusNumber) {
		List<Integer> winningLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		assertThatThrownBy(() -> new WinningLotto(winningLottoNumbers, bonusNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

}