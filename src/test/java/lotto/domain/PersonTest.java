package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class PersonTest {

	@ParameterizedTest
	@CsvSource({"3000, 0", "3300, 300"})
	void 사람이_로또를_계속_살_수_있다(long initialAmount, long remainAmount) {
		// given
		Person person = Person.of(initialAmount);

		// when
		person.buyLottoWithAllMoney();

		// then
		assertThat(person).isEqualTo(Person.of(remainAmount, Arrays.asList(new Lotto(), new Lotto(), new Lotto())));
	}

}
