package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class PersonTest {

	@Test
	void 사람이_로또를_살_수_있다() {
		// given
		Person person = Person.of(1000L);

		// when
		person.buyLotto();

		// then
		assertThat(person).isEqualTo(Person.of(0L, Collections.singletonList(new Lotto())));
	}

}
