package camp.nextcamp.edu.lotto.entity;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextcamp.edu.lotto.exception.UserException;
import camp.nextcamp.edu.lotto.exception.UserExceptionMesssage;
import camp.nextcamp.edu.lotto.module.LottoModule;

public class ManualLottoTest {

	@ParameterizedTest
	@DisplayName("ManualLottoTicket 생성 success")
	@ValueSource(strings = {"1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 8", "2, 3, 7, 8, 9, 20"})
	void ManualLottoTicket_success(String input) {
		// given
		List<String> list = new ArrayList<String>() {{
			add(input);
		}};

		// when
		ManualLottoTicket manualLottoTicket = new ManualLottoTicket(list, 1);

		// then
		assertThat(manualLottoTicket.getTicketCount())
			.isEqualTo(1);
	}

	@Test
	@DisplayName("ManualLottoTicket 생성 fail")
	void ManualLottoTicket_fail() {
		// given
		List<String> list = new ArrayList<String>() {{
			add("1, 2, 3, 4, 5, 6");
			add("1, 2, 3, 4, 5, 7");
			add("1, 2, 3, 4, 5, 8");
		}};

		// then
		assertThatExceptionOfType(UserException.class)
			.isThrownBy(() -> new ManualLottoTicket(list, 2))
			.withMessageMatching(UserExceptionMesssage.ILLEGAL_MANUAL_LOTTO_COUNT.getMessage());
	}

}
