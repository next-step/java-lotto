package domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoTest {

	@Test
	void 로또1장에_번호6개가있다() {
		Lotto lotto = new Lotto(List.of(
			new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
			new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
		));
		assertThat(lotto.getNumbers()).hasSize(6);
	}

	@Test
	void 번호가_6개보다_작게_생성되면_예외를_발생한다() {
		assertThatThrownBy(() -> new Lotto(List.of(
			new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
			new LottoNumber(4), new LottoNumber(5)
		))).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 번호가_7개면_예외를_발생한다() {
		assertThatThrownBy(() -> new Lotto(List.of(
			new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
			new LottoNumber(4), new LottoNumber(5), new LottoNumber(6), new LottoNumber(6)
		))).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 번호가_중복되면_예외를_발생시킨다() {
		assertThatThrownBy(() -> new Lotto(List.of(
			new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
			new LottoNumber(4), new LottoNumber(6), new LottoNumber(6)
		))).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 로또번호는_오름차순으로_정렬된다() {
		Lotto lotto = new Lotto(List.of(
			new LottoNumber(6), new LottoNumber(5), new LottoNumber(4),
			new LottoNumber(3), new LottoNumber(2), new LottoNumber(1)));

		assertThat(lotto.getNumbers()).extracting(LottoNumber::getNumber)
			.containsExactly(1, 2, 3, 4, 5, 6);
	}

	@Test
	void 맞은_로또번호의_개수를_반환한다() {
		Lotto lotto = new Lotto(List.of(
			new LottoNumber(6), new LottoNumber(5), new LottoNumber(4),
			new LottoNumber(3), new LottoNumber(2), new LottoNumber(1)));

		Lotto other = new Lotto(List.of(
			new LottoNumber(9), new LottoNumber(8), new LottoNumber(7),
			new LottoNumber(3), new LottoNumber(2), new LottoNumber(1)));

		assertThat(lotto.countMatch(other)).isEqualTo(3);
	}
}
