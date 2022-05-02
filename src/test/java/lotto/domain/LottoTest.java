package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

	@DisplayName("로또 번호가 설정한 개수만큼 생성")
	@Test
	public void When_createdLotto_Expected_6LottoNumber() {
		Lotto lotto = new Lotto(Set.of(
			new LottoNumber(1),
			new LottoNumber(2),
			new LottoNumber(3),
			new LottoNumber(4),
			new LottoNumber(5),
			new LottoNumber(6)
			));

		assertThat(lotto.size()).isEqualTo(Lotto.LOTTO_SIZE);
	}

	@DisplayName("로또 번호 중복 시, IllegalArgumentException 발생")
	@Test
	public void When_createdSameNumberLotto_Expected_IllegalArgumentException() {
		assertThatThrownBy(() -> new Lotto(Set.of(
			new LottoNumber(1),
			new LottoNumber(1),
			new LottoNumber(1),
			new LottoNumber(1),
			new LottoNumber(1),
			new LottoNumber(1)
		))).isInstanceOf(IllegalArgumentException.class);
	}


	@DisplayName("로또의 로또번호가 6개가 아니면, IllegalArgumentException 발생")
	@Test
	public void When_created5NumberLotto_Expected_IllegalArgumentException() {
		assertThatThrownBy(() -> new Lotto(Set.of(
			new LottoNumber(1),
			new LottoNumber(2),
			new LottoNumber(3),
			new LottoNumber(4),
			new LottoNumber(5)
		))).isInstanceOf(IllegalArgumentException.class);
	}
}
