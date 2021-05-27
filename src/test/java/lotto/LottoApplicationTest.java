package lotto;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoApplicationTest {

	@DisplayName("로또 애플리케이션 실행 테스트")
	@Test
	void run_with_manual_lotto() {
		// given
		String userInputData = "100000\r\n3\r\n1,2,3,4,5,6\r\n11,12,13,14,15,16\r\n21,22,23,24,25,26\r\n1,2,3,4,5,6\r\n7\r\n";
		System.setIn(new ByteArrayInputStream(userInputData.getBytes()));
		LottoApplication lottoApplication = new LottoApplication(new Console());

		// when
		int signal = lottoApplication.run();

		// then
		assertThat(signal).isEqualTo(LottoApplication.NORMAL_SIGNAL);
	}

	@DisplayName("로또 애플리케이션 실행 테스트")
	@Test
	void run_without_manual_lotto() {
		// given
		String userInputData = "100000\r\n0\r\n1,2,3,4,5,6\r\n7\r\n";
		System.setIn(new ByteArrayInputStream(userInputData.getBytes()));
		LottoApplication lottoApplication = new LottoApplication(new Console());

		// when
		int signal = lottoApplication.run();

		// then
		assertThat(signal).isEqualTo(LottoApplication.NORMAL_SIGNAL);
	}
}
