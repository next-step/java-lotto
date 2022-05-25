package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoTest {

	public static Lotto MANUAL_LOTTO_1 = Lotto.createManual(Set.of(
		LottoNumber.from(1),
		LottoNumber.from(2),
		LottoNumber.from(3),
		LottoNumber.from(4),
		LottoNumber.from(5),
		LottoNumber.from(6)
	));

	public static Lotto MANUAL_LOTTO_2 = Lotto.createManual(Set.of(
		LottoNumber.from(21),
		LottoNumber.from(5),
		LottoNumber.from(8),
		LottoNumber.from(30),
		LottoNumber.from(44),
		LottoNumber.from(22)
	));

	public static Lotto MANUAL_LOTTO_3 = Lotto.createManual(Set.of(
		LottoNumber.from(7),
		LottoNumber.from(17),
		LottoNumber.from(29),
		LottoNumber.from(36),
		LottoNumber.from(39),
		LottoNumber.from(1)
	));

	@DisplayName("로또 번호가 설정한 개수만큼 생성")
	@Test
	public void When_createdLotto_Expected_6LottoNumber() {

		assertThat(MANUAL_LOTTO_1.size()).isEqualTo(Lotto.LOTTO_SIZE);
	}

	@DisplayName("로또 번호 중복 시, IllegalArgumentException 발생")
	@Test
	public void When_createdSameNumberLotto_Expected_IllegalArgumentException() {
		assertThatThrownBy(() -> Lotto.createManual(Set.of(
			LottoNumber.from(1),
			LottoNumber.from(1),
			LottoNumber.from(1),
			LottoNumber.from(1),
			LottoNumber.from(1),
			LottoNumber.from(1)
		))).isInstanceOf(IllegalArgumentException.class);
	}


	@DisplayName("로또의 로또번호가 6개가 아니면, IllegalArgumentException 발생")
	@Test
	public void When_created5NumberLotto_Expected_IllegalArgumentException() {
		assertThatThrownBy(() -> Lotto.createManual(Set.of(
			LottoNumber.from(1),
			LottoNumber.from(2),
			LottoNumber.from(3),
			LottoNumber.from(4),
			LottoNumber.from(5)
		))).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또숫자 포함 여부")
	@CsvSource(value = {"1, 2, 3, 4, 5, 6:3:true", "1,2,3,4,5,6:7:false"}, delimiter = ':')
	@ParameterizedTest
	public void When_GivenLottoNumber_Expected_ContainOrNot(String lottoInput, int number, boolean expected) {
		Lotto lotto = Lotto.createManual(
			Arrays.stream(lottoInput.split(Lotto.SPLIT_DELIMITER))
				.map(LottoNumber::from)
				.collect(Collectors.toSet()));

		assertThat(lotto.contain(LottoNumber.from(number)))
			.isEqualTo(expected);
	}
}
