package step2.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.util.FixLottoGenerator;
import step2.util.LottoGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

	Lotto lotto;
	LottoGenerator lottoGenerator;

	@ParameterizedTest
	@MethodSource("checkHitArguments")
	void checkHit(String fixedNumber, int expectHitNum) {
		lottoGenerator = new FixLottoGenerator(fixedNumber);
		lotto = Lotto.generate(lottoGenerator);
		List<Integer> list = Arrays.asList(1,2,3,6,7,8);
		assertEquals(lotto.checkHit(list), expectHitNum);
	}

	static Stream<Arguments> checkHitArguments(){
		return Stream.of(
				Arguments.arguments("1,2,3,7,8,9", 5),
				Arguments.arguments("4,5,6,11,34,21", 1)
		);
	}
}