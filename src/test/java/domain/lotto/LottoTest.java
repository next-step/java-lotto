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

}
