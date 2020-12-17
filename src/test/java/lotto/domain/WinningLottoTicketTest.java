package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class WinningLottoTicketTest {

	@DisplayName("1. 당첨 번호는 빈 값을 입력할 수 없다.")
	@ParameterizedTest
	@NullSource
	@EmptySource
	@ValueSource(strings = {""})
	public void inputCannotNullOrEmpty(String arg) {

		assertThatThrownBy(() -> {
			WinningLottoTicket winningLottoTicket = new WinningLottoTicket(arg);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("지난 주 당첨 번호를 입력해 주세요.");
	}

}
