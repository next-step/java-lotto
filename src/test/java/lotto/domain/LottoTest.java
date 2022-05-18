package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoTest {

	@DisplayName("로또 번호가 설정한 개수만큼 생성")
	@Test
	public void When_createdLotto_Expected_6LottoNumber() {
		Lotto lotto = new Lotto(Set.of(
			LottoNumber.of(1),
			LottoNumber.of(2),
			LottoNumber.of(3),
			LottoNumber.of(4),
			LottoNumber.of(5),
			LottoNumber.of(6)
			));

		assertThat(lotto.size()).isEqualTo(Lotto.LOTTO_SIZE);
	}

	@DisplayName("로또 번호 중복 시, IllegalArgumentException 발생")
	@Test
	public void When_createdSameNumberLotto_Expected_IllegalArgumentException() {
		assertThatThrownBy(() -> new Lotto(Set.of(
			LottoNumber.of(1),
			LottoNumber.of(1),
			LottoNumber.of(1),
			LottoNumber.of(1),
			LottoNumber.of(1),
			LottoNumber.of(1)
		))).isInstanceOf(IllegalArgumentException.class);
	}


	@DisplayName("로또의 로또번호가 6개가 아니면, IllegalArgumentException 발생")
	@Test
	public void When_created5NumberLotto_Expected_IllegalArgumentException() {
		assertThatThrownBy(() -> new Lotto(Set.of(
			LottoNumber.of(1),
			LottoNumber.of(2),
			LottoNumber.of(3),
			LottoNumber.of(4),
			LottoNumber.of(5)
		))).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또숫자 포함 여부")
	@CsvSource(value = {"1, 2, 3, 4, 5, 6:3:true", "1,2,3,4,5,6:7:false"}, delimiter = ':')
	@ParameterizedTest
	public void When_GivenLottoNumber_Expected_ContainOrNot(String lottoInput, int number, boolean expected) {
		Lotto lotto = new Lotto(lottoInput);

		assertThat(lotto.contain(LottoNumber.of(number)))
			.isEqualTo(expected);
	}
}
