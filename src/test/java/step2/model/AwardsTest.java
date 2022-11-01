package step2.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class AwardsTest {

	@ParameterizedTest
	@MethodSource("findAwardArguments")
	void findAward(int hitCnt, Awards expect) {
		assertEquals(Awards.findAward(hitCnt), expect);
	}

	static Stream<Arguments> findAwardArguments(){
		return Stream.of(
				arguments(3, Awards.THREE),
				arguments(4, Awards.FOUR),
				arguments(5, Awards.FIVE),
				arguments(6, Awards.SIX),
				arguments(234, Awards.DEFAULT)
		);
	}

	@ParameterizedTest
	@MethodSource("getAwardArguments")
	void getAward(int hitCnt, int expect) {
		assertEquals(Awards.findAward(hitCnt).getAward(), expect);
	}

	static Stream<Arguments> getAwardArguments(){
		return Stream.of(
				arguments(3, 5000),
				arguments(4, 50000),
				arguments(5, 150000),
				arguments(6, 2000000000)
		);
	}
}