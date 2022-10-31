package step2.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MoneyTest {
	@ParameterizedTest
	@MethodSource("getMoneyArgument")
	void LottoTicketCntTest(Money money) {
		assertEquals(money.getTicketCnt(), money.getMoney() / 1000);
	}

	static Stream<Arguments> getMoneyArgument(){
		return Stream.of(
				arguments(new Money(15000)),
				arguments(new Money(1000)),
				arguments(new Money(20000))
		);
	}
}