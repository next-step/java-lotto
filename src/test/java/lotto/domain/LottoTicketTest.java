package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

	@DisplayName("유효성 검증 테스트")
	@Test
	void invalid_length() {
		// given
		HashSet<LottoNumber> lottoNumbers = new HashSet<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2)));

		// then
		assertThatThrownBy(() -> new LottoTicket(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
	}

}
