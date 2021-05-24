package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoApplicationTest {

	@DisplayName("로또 애플리케이션 실행 테스트")
	@Test
	void run() {
		// given
		UserInterface mockupInterface = new MockupInterface();
		LottoApplication lottoApplication = new LottoApplication(mockupInterface);

		// when
		int signal = lottoApplication.run();

		// then
		assertThat(signal).isEqualTo(LottoApplication.NORMAL_SIGNAL);
	}

}
