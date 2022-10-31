package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

class LottoTest {

	@DisplayName("Default Constructor로 로또를 생성하면 여섯개의 숫자를 생성한다.")
	@Test
	void Should_Have_Six_Number_When_Create_Lotto_By_Deafult_Constructor() {
		Lotto lotto = new Lotto();

		assertThat(lotto.getNumbers().size()).isEqualTo(Lotto.LOTTO_NUMBER_QUANTITY);
	}

	@DisplayName("생성된 로또의 여섯가지 숫자는 1~45 사이의 숫자이어야 한다.")
	@Test
	void Should_Be_Between_1_And_45_When_Create_Lotto() {
		Lotto lotto = new Lotto();

		assertThat(lotto.getNumbers().stream()
			.allMatch(number -> number >= 1 && number <= 45))
			.isTrue();
	}
}
