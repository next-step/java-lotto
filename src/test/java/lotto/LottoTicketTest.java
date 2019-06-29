package lotto;

import common.NumberElement;
import lotto.exception.DuplicateNumberException;
import lotto.exception.OutOfCountException;
import lotto.exception.OutOfBoundLottoNumberException;
import lotto.domain.LottoTicket;
import lotto.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {

	@DisplayName("중복된 번호 입력")
	@Test
	void addSameNumber() {

		int[] numbers = {1, 1, 2, 3, 4, 5};

		assertThatExceptionOfType(DuplicateNumberException.class).isThrownBy(() -> {
			LottoTicket.of(numbers);
		});
	}

	@DisplayName("허용된 개수 이상 입력")
	@Test
	void addOverCount() {
		int[] numbers = {1, 2, 3, 4, 5, 6, 7};

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			LottoTicket.of(numbers);
		});
	}

	@DisplayName("허용된 숫자 이상 입력")
	@Test
	void addOverLimit() {
		int[] numbers = {1, 2, 3, 4, 5, LottoRule.MAX_NUMBER + 1};

		assertThatExceptionOfType(OutOfBoundLottoNumberException.class).isThrownBy(() -> {
			LottoTicket.of(numbers);
		});
	}

	@DisplayName("복권 당첨 확인")
	@ParameterizedTest
	@MethodSource("provideWinNumbers")
	void checkWin(int[] winNumbers, int bonus, LottoResult expectResult) {
		// Arrange
		LottoTicket ticket = LottoTicket.of(new int[]{1, 2, 3, 4, 5, 6});
		WinNumber winNumber = new WinNumber(LottoNumberSet.of(winNumbers), new LottoNumber(bonus));

		// Action
		LottoResult result = ticket.checkWin(winNumber);

		// Assertion
		assertThat(result).isEqualTo(expectResult);
	}

	private static Stream<Arguments> provideWinNumbers(){
		return Stream.of(
				Arguments.of(new int[]{7, 8, 9, 10, 11, 12}, 45, LottoResult.FAIL),	// 낙첨
				Arguments.of(new int[]{2, 4, 6, 10, 11, 12}, 45, LottoResult.WIN_5TH),	// 4등
				Arguments.of(new int[]{1, 2, 3, 10, 11, 12}, 45, LottoResult.WIN_5TH),	// 4등
				Arguments.of(new int[]{1, 2, 3, 4, 11, 12}, 45, LottoResult.WIN_4TH),	// 3등
				Arguments.of(new int[]{1, 2, 3, 4, 5, 12}, 45, LottoResult.WIN_3RD),	// 2등
				Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 45, LottoResult.WIN_1ST)		// 1등
		);
	}

	@DisplayName("toString 반환 테스트")
	@Test
	void verifyToString() {
		LottoTicket ticket = LottoTicket.of(new int[]{6, 4, 3, 2, 5, 1});

		assertThat(ticket.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
	}
}