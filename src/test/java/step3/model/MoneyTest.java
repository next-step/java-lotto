package step3.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.model.Money;

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
		assertEquals(objMoney.getTicketCnt(), ticketCnt);
	}
}
