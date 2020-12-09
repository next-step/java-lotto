package com.woowahan.lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottosTest {

	@DisplayName("purchase 메서드에 PurchaseInput객체를 전달해서 Lottos객체를 생성할 수 있다.")
	@ParameterizedTest
	@MethodSource("argPurchase")
	void purchase(PurchaseInput input) {

		Lottos lottos = Lottos.purchase(input);
		assertThat(lottos).isInstanceOf(Lottos.class);
	}

	public static Stream<Arguments> argPurchase() {
		return Stream.of(
			Arguments.of(PurchaseInput.of("1000")),
			Arguments.of(PurchaseInput.of("5000")),
			Arguments.of(PurchaseInput.of("10000")),
			Arguments.of(PurchaseInput.of("20000")),
			Arguments.of(PurchaseInput.of("100000"))
		);
	}
}