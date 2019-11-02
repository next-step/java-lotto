package lotto.domain.person;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCreator;
import lotto.domain.lotto.LottoNumbersGeneratePolicy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class PersonTest {

	private static List<Integer> DEFAULT_LOTTO_NUMBERS =
			IntStream.range(1, 7).boxed(). collect(Collectors.toList());

	@ParameterizedTest
	@CsvSource({"3000, 0", "3300, 300"})
	void 사람이_로또를_계속_살_수_있다(long initialAmount, long remainAmount) {
		// given
		Person person = Person.of(initialAmount);

		// when
		person.buyLottoWithAllMoney(LottoCreator.of(new SimpleNumberGenerator()));

		// then
		assertThat(person).isEqualTo(Person.of(remainAmount,
				Arrays.asList(Lotto.of(DEFAULT_LOTTO_NUMBERS),
						Lotto.of(DEFAULT_LOTTO_NUMBERS),
						Lotto.of(DEFAULT_LOTTO_NUMBERS))));
	}

	private static class SimpleNumberGenerator implements LottoNumbersGeneratePolicy {

		@Override
		public List<Integer> generate() {
			return DEFAULT_LOTTO_NUMBERS;
		}

	}

}
