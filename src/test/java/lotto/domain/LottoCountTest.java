package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCountTest {

	@Test
	@DisplayName("로또 개수 생성 테스트")
	public void createLottoCount() {
		LottoCount lottoCount = new LottoCount(5);
		assertThat(lottoCount.getCount()).isEqualTo(5);
	}

	@Test
	@DisplayName("로또 개수 - 입력 시 에러 발생 테스트")
	public void createErrorLottoCount() {
		assertThatThrownBy(() -> {
			new LottoCount(-1);
		}).isInstanceOf(IllegalArgumentException.class);

	}
}
