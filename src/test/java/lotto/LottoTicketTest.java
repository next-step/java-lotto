package lotto;

import lotto.exception.DuplicateNumberException;
import lotto.exception.OutOfCountException;
import lotto.exception.OutOfMaxNumberException;
import model.NumberElement;
import model.NumberElementCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {

	@DisplayName("중복된 번호 입력")
	@Test
	void addSameNumber() {

		LottoTicket ticket = new LottoTicket();
		ticket.add(1);

		assertThatExceptionOfType(DuplicateNumberException.class).isThrownBy(() -> {
			ticket.add(1);
		});
	}

	@DisplayName("허용된 개수 이상 입력")
	@Test
	void addOverCount() {
		int[] numbers = {1, 2, 3, 4, 5, 6};
		LottoTicket ticket = new LottoTicket();

		for(int number : numbers){
			ticket.add(number);
		}

		assertThatExceptionOfType(OutOfCountException.class).isThrownBy(() -> {
			ticket.add(7);
		});
	}

	@DisplayName("허용된 숫자 이상 입력")
	@Test
	void addOverLimit() {
		LottoTicket ticket = new LottoTicket();

		assertThatExceptionOfType(OutOfMaxNumberException.class).isThrownBy(() -> {
			ticket.add(LottoRule.MAX_NUMBER + 1);
		});
	}

	@DisplayName("복권 당첨 확인")
	@ParameterizedTest
	@MethodSource("provideWinNumbers")
	void checkWin(int[] winNumbers, LottoResult expectResult) {
		// Arrange
		LottoTicket ticket = new LottoTicket();
		ticket.add(new int[]{1, 2, 3, 4, 5, 6});

		NumberElementCollection numbers = new NumberElementCollection(6);
		for(int number : winNumbers){
			numbers.add(number);
		}

		// Action
		LottoResult result = ticket.checkWin(numbers);

		// Assertion
		assertThat(result).isEqualTo(expectResult);
	}

	private static Stream<Arguments> provideWinNumbers(){
		return Stream.of(
				Arguments.of(new int[]{7, 8, 9, 10, 11, 12}, LottoResult.FAIL),	// 낙첨
				Arguments.of(new int[]{2, 4, 6, 43, 44, 45}, LottoResult.WIN_4TH),	// 4등
				Arguments.of(new int[]{1, 2, 3, 43, 44, 45}, LottoResult.WIN_4TH),	// 4등
				Arguments.of(new int[]{1, 2, 3, 4, 44, 45}, LottoResult.WIN_3RD),	// 3등
				Arguments.of(new int[]{1, 2, 3, 4, 5, 45}, LottoResult.WIN_2ND),	// 2등
				Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, LottoResult.WIN_1ST)		// 1등
		);
	}

	@DisplayName("기준에 맞지 않는 당첨번호 (개수 부족)")
	@Test
	void illegalWinNumbers() {
		// Arrange
		LottoTicket ticket = new LottoTicket();

		int[] winNumbers = new int[]{1, 2, 3, 4, 5};
		NumberElementCollection numbers = new NumberElementCollection(6);
		for(int number : winNumbers){
			numbers.add(number);
		}

		// Action & Assertion
		assertThatIllegalArgumentException().isThrownBy(() -> {ticket.checkWin(numbers);});
	}

	@DisplayName("toString 반환 테스트")
	@Test
	void verifyToString() {
		LottoTicket ticket = new LottoTicket();
		ticket.add(new int[]{1, 2, 3, 4, 5, 6});

		assertThat(ticket.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
	}
}