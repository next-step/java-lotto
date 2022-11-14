package step4.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AwardsTest {
	@ParameterizedTest
	@MethodSource("getPrizeArguments")
	void getPrize(int awardRank, int awardCnt, int prize) {
		assertEquals(step3.model.Awards.getPrize(awardRank, awardCnt), prize);
	}

	static Stream<Arguments> getPrizeArguments(){
		return Stream.of(
				arguments(5, 5, 25000),
				arguments(4, 4, 200000),
				arguments(3, 3, 450000),
				arguments(2, 2, 60000000),
				arguments(1, 1, 2000000000)
		);
	}

	@ParameterizedTest
	@MethodSource("getHitCntArguments")
	void getHitCnt(int rank, int hitCnt) {
		assertEquals(step3.model.Awards.getHitCnt(rank), hitCnt);
	}

	static Stream<Arguments> getHitCntArguments(){
		return Stream.of(
				arguments(1, 6),
				arguments(2, 5),
				arguments(3, 5),
				arguments(4, 4),
				arguments(5, 3)
		);
	}

	@ParameterizedTest
	@MethodSource("getAwardArguments")
	void getAward(int rank, int prize) {
		assertEquals(Awards.getAward(rank), prize);
	}

	static Stream<Arguments> getAwardArguments() {
		return Stream.of(
				arguments(1, 2000000000),
				arguments(2, 30000000),
				arguments(3, 150000),
				arguments(4, 50000),
				arguments(5, 5000)
		);
	}
}