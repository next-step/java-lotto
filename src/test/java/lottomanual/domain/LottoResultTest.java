package lottomanual.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoResultTest {

	@Test
	@DisplayName("당첨 번호와 보너스 번호 중복 예외")
	void duplicate_bonus_number() throws Exception {
		//given
		Lottos lottos = new Lottos();
		lottos.buy(toSet(Arrays.asList(1,2,3,4,5,6)));

		LottoResult lottoResult = new LottoResult(lottos);

		Lotto winningNumbers = new Lotto("1, 2, 3, 4, 5, 6");
		LottoNumber bonusNumber = LottoNumber.valueOf(6);

		//when

		//then
		assertThatThrownBy(() -> lottoResult.match(winningNumbers, bonusNumber))
				.isInstanceOf(LottoBonusNumberException.class);

	}

	@ParameterizedTest(name = "당첨 등수별 수량 {index} [{arguments}]")
	@MethodSource
	@DisplayName("당첨 등수별 수량")
	void match(Set<LottoNumber> lottoNumbers, int quantity, boolean matchBonus, int matchingCount) throws Exception {
		//given
		Lottos lottos = new Lottos();
		lottos.buy(lottoNumbers);
		LottoResult lottoResult = new LottoResult(lottos);
		lottoResult.match(new Lotto("1, 2, 3, 4, 5, 6"), LottoNumber.valueOf(7));

		//when
		Map<LottoProfit, Integer> result = lottoResult.value();
		LottoProfit lottoProfit = LottoProfit.of(quantity, matchBonus);

		//then
		assertThat(result).containsEntry(lottoProfit, matchingCount);

	}

	private static Stream<Arguments> match() {
		return Stream.of(
				Arguments.of(toSet(Arrays.asList(1,2,3,11,12,13)), 3, false, 1),
				Arguments.of(toSet(Arrays.asList(1,2,3,11,12,13)), 3, true, 1),
				Arguments.of(toSet(Arrays.asList(1,2,3,4,11,12)), 4, false, 1),
				Arguments.of(toSet(Arrays.asList(1,2,3,4,11,12)), 4, true, 1),
				Arguments.of(toSet(Arrays.asList(1,2,3,4,5,11)), 5, false, 1),
				Arguments.of(toSet(Arrays.asList(1,2,3,4,5,7)), 5, true, 1),
				Arguments.of(toSet(Arrays.asList(1,2,3,4,5,6)), 6, false, 1),
				Arguments.of(toSet(Arrays.asList(1,2,3,4,5,6)), 6, true, 1)
		);
	}

	@ParameterizedTest(name = "당첨률 {index} [{arguments}]")
	@MethodSource
	@DisplayName("당첨률")
	void rate(Set<LottoNumber> buyFirstLottoNumbers, Set<LottoNumber> buySecondLottoNumbers, double expectedRate) throws Exception {
		//given
		Lottos lottos = new Lottos();
		lottos.buy(buyFirstLottoNumbers);
		lottos.buy(buySecondLottoNumbers);
		LottoResult lottoResult = new LottoResult(lottos);
		lottoResult.match(new Lotto("1, 2, 3, 4, 5, 6"), LottoNumber.valueOf(7));

		//when
		double rate = lottoResult.rate();

		//then
		assertThat(rate).isEqualTo(expectedRate);

	}

	private static Stream<Arguments> rate() {
		return Stream.of(
				Arguments.of(toSet(Arrays.asList(11, 12, 13, 14, 15, 16)), toSet(Arrays.asList(11, 12, 13, 14, 15, 16)), 0.00),
				Arguments.of(toSet(Arrays.asList(1, 2, 3, 4, 5, 6)), toSet(Arrays.asList(11, 12, 13, 14, 15, 16)), 0.50),
				Arguments.of(toSet(Arrays.asList(1, 2, 3, 4, 5, 6)), toSet(Arrays.asList(1, 2, 3, 4, 5, 6)), 1.00)
		);
	}

	private static Set<LottoNumber> toSet(List<Integer> list) {
		return list.stream().map(LottoNumber::valueOf).collect(Collectors.toCollection(TreeSet::new));
	}

}