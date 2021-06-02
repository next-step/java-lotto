package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoMachineTest {

	@DisplayName("금액에 해당하는 만큼의 로또를 구매한다.")
	@ParameterizedTest
	@CsvSource({ "1000,1", "15000,15", "500,0" })
	void purchaseLotto(int money, int expected) {
		LottoMachine lottoMachine = new LottoMachine(money, Collections.emptyList());
		assertThat(lottoMachine.purchasedAutoLottoCount()).isEqualTo(expected);
	}

	@DisplayName("자동 로또 수는 최대 구매 가능한 수에 수동으로 구매한 로또 수를 제한 만큼이다.")
	@ParameterizedTest
	@MethodSource("generateData")
	void purchaseLotto(List<Lotto> manualLotto, int money, int expected) {
		LottoMachine lottoMachine = new LottoMachine(money, manualLotto);
		assertThat(lottoMachine.purchasedAutoLottoCount()).isEqualTo(expected);
	}

	@DisplayName("수동 로또 수는 최대 구매 가능한 수를 넘을 수는 없다.")
	@ParameterizedTest
	@MethodSource("generateOverData")
	void purchaseLottoOverMax(List<Lotto> manualLotto, int money) {
		assertThatThrownBy(() -> new LottoMachine(money, manualLotto))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("구매할 수 있는 최대 갯수를 넘었습니다.");
	}

	static Stream<Arguments> generateOverData() {
		return Stream.of(
			Arguments.of(lottosData().subList(0, 5), 1000),
			Arguments.of(lottosData().subList(0, 8), 7000)
		);
	}

	static Stream<Arguments> generateData() {
		return Stream.of(
			Arguments.of(lottosData().subList(0, 2), 5000, 3),
			Arguments.of(lottosData().subList(0, 5), 15000, 10),
			Arguments.of(lottosData().subList(0, 8), 8000, 0),
			Arguments.of(Collections.emptyList(), 5000, 5)
		);
	}

	static List<Lotto> lottosData() {
		return Arrays.asList(
			new Lotto(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Stream.of(1, 2, 3, 4, 6, 7).map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Stream.of(1, 22, 33, 4, 6, 7).map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Stream.of(10, 20, 30, 40, 16, 17).map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Stream.of(1, 2, 3, 4, 6, 7).map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Stream.of(1, 2, 23, 22, 26, 7).map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Stream.of(1, 2, 3, 4, 36, 37).map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Stream.of(1, 2, 3, 4, 26, 27).map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Stream.of(1, 2, 3, 4, 6, 7).map(LottoNumber::new).collect(Collectors.toList())));
	}
}
