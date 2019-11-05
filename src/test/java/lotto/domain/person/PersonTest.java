package lotto.domain.person;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCreator;
import lotto.domain.lotto.LottoType;
import lotto.domain.lotto.policy.LottoNumbersGeneratePolicy;
import lotto.domain.lotto.policy.SelfLottoNumberGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
		person.buyLottoWithAllMoney(LottoCreator.of(new SimpleNumberGenerator(), LottoType.AUTO));

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

	@Test
	void 사람이_수동으로_로또를_살_수_있다() {
		// given
		Person person = Person.of(5000L);

		// when
		person.buyLottoSelf(LottoCreator.of(new SelfLottoNumberGenerator(DEFAULT_LOTTO_NUMBERS), LottoType.SELF));

		// then
		assertThat(person).isEqualTo(Person.of(4000L, Collections.singletonList(Lotto.of(DEFAULT_LOTTO_NUMBERS))));
	}

	@Test
	void 수동으로_로또를_살때_로또_숫자_범위를_벗어나면_안된다() {
		// given
		Person person = Person.of(1000L);
		List<Integer> outRangedNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);

		// when
		assertThatThrownBy(() -> {
			person.buyLottoSelf(LottoCreator.of(new SelfLottoNumberGenerator(outRangedNumbers), LottoType.SELF));
		})
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("1 ~ 45");
	}

	@Test
	void 수동으로_로또를_살때_중복된_숫자를_찍으면_안된다() {
		// given
		Person person = Person.of(1000L);
		List<Integer> outRangedNumbers = Arrays.asList(1, 2, 2, 4, 5, 45);

		// when
		assertThatThrownBy(() -> {
			person.buyLottoSelf(LottoCreator.of(new SelfLottoNumberGenerator(outRangedNumbers), LottoType.SELF));
		})
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("중복");
	}

}
