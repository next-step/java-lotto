package com.nextstep.lotto.result;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.nextstep.lotto.lotto.WinningLotto;

public class WinningLottoTest {

	@DisplayName("입력한 번호를 쉼표로 구분하여 당첨번호를 만드는지 테스트")
	@Test
	void 당첨번호를_쉼표로_구분하여_저장하는지_테스트() {
		String input = "1,2,3,4,5,6";
		WinningLotto winningLotto = new WinningLotto(input);
		assertThat(winningLotto.getWinningLotto().getLottoNumbers().size()).isEqualTo(6);
	}

	@DisplayName("범위를 벗어난 값을 입력했을때 Exception을 발생시키는지 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"-1,2,3,4,5,6", "1,2,3,4,5,0", "45,46,1,2,3,4"})
	void 음수_혹은_범위를_벗어나면_exception_발생하는지_테스트(String input) {
		assertThatThrownBy(() -> new WinningLotto(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("숫자를 6개 이외에 다른 개수만큼 입력했을때 Exception을 발생시키는지 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"2,3,4,5,6", "", "1,2,3,4,5,6,7"})
	void 입력한_숫자의_개수가_6개가_아닐때_exception_발생하는지_테스트(String input) {
		assertThatThrownBy(() -> new WinningLotto(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("문자를 입력했을때 Exception을 발생시키는지 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"2,3,4,5,6,a", "a,b,c,d,e,f"})
	void 숫자_이외에_문자를_입력했을때_exception_발생하는지_테스트(String input) {
		assertThatThrownBy(() -> new WinningLotto(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("문자를 입력했을때 Exception을 발생시키는지 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"2,3,4,5,6,6", "1,2,3,3,4,5"})
	void 중복된_숫자를_입력했을때_exception_발생하는지_테스트(String input) {
		assertThatThrownBy(() -> new WinningLotto(input)).isInstanceOf(IllegalArgumentException.class);
	}
}
