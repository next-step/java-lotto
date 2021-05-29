package wootecam.lotto.model;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import wootecam.lotto.exception.LottoException;

class BonusNumberTest {

	private Lotto winningLotto;

	@BeforeEach
	void setUp() {
		winningLotto = new Lotto(
			Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4),
				LottoNumber.of(5), LottoNumber.of(6)));
	}

	@Test
	@DisplayName("보너스 번호의 범위가 0~45를 벗어난 경우")
	void testCreateBonusNumber() {
		Assertions.assertThatThrownBy(() -> {
			new BonusNumber(LottoNumber.of(99), winningLotto);
		}).isInstanceOf(LottoException.class)
			.hasMessageContaining("로또 번호는 1~45만 가능합니다.");
	}

	@Test
	@DisplayName("보너스 번호가 로또번호와 중복된경우")
	void testDuplicateBonusNumber() {
		Assertions.assertThatThrownBy(() -> {
			new BonusNumber(LottoNumber.of(1), winningLotto);
		}).isInstanceOf(LottoException.class)
			.hasMessageContaining("보너스 번호가 로또번호와 중복됩니다.");
	}

	@Test
	@DisplayName("보너스 번호 숫자가 아닌경우 오류발생")
	void test숫자아닌경우() {
		Assertions.assertThatThrownBy(() -> {
			new BonusNumber(LottoNumber.of("1o"), winningLotto);
		}).isInstanceOf(LottoException.class)
			.hasMessageContaining("정수형이 아닙니다.");
	}
}