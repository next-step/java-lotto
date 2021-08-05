package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

	@Test
	@DisplayName("원하는 숫자로 로또 번호가 생성이 되었는가")
	void generateDesiredLottoNumber() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		Lotto lotto = new Lotto(list);

		assertThat(lotto.equals(new Lotto(list))).isTrue();
	}
}