package step4.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {
	public static Stream<Arguments> getTicketCntMethod() {
		return Stream.of(
				Arguments.arguments(50000, 50),
				Arguments.arguments(1000, 1),
				Arguments.arguments(10000, 10)
		);
	}

	@ParameterizedTest
	@MethodSource("getTicketCntMethod")
	void getTicketCntTest(int money, int ticketCnt){
		Money objMoney = new Money(money);
		assertEquals(objMoney.getLottoTicketCnt(), ticketCnt);
	}

	public static Stream<Arguments> moneyValidationCheckMethod() {
		return Stream.of(
				Arguments.arguments(100),
				Arguments.arguments(900),
				Arguments.arguments(-100)
		);
	}

	@ParameterizedTest(name = "")
	@MethodSource("moneyValidationCheckMethod")
	void moneyValidationCheckTest(int money){
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Money(money));
	}
}
