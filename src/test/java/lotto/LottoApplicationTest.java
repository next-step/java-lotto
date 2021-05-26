package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class LottoApplicationTest {

	@DisplayName("로또 애플리케이션 실행 테스트")
	@Test
	void run() {
		// given
		String userInputData = "100000\r\n1,2,3,4,5,6\r\n7\r\n";
		System.setIn(new ByteArrayInputStream(userInputData.getBytes()));
		LottoApplication lottoApplication = new LottoApplication(new Console());

		// when
		int signal = lottoApplication.run();

		// then
		assertThat(signal).isEqualTo(LottoApplication.NORMAL_SIGNAL);
	}

}
