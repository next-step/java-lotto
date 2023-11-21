package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoListTest {
	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("LottoList 는 아무런 로또번호가 주어지지 않으면 예외를 던진다")
	void newObject_nullAndEmptyLottoList_throwsException(List<Lotto> emptyLotto) {

		assertThatThrownBy(
				() -> new LottoList(emptyLotto)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
