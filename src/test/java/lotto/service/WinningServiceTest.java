package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
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

import lotto.collections.LottoResult;
import lotto.collections.LottoTickets;
import lotto.collections.RewardType;
import lotto.collections.WinningNumbers;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

public class WinningServiceTest {

	private static Stream<Arguments> lottoStatisticsMock() { // argument source method
		// Map<Integer, Integer> oneLottoStatistics = new HashMap<>();
		// oneLottoStatistics.put(1, 1);
		// oneLottoStatistics.put(2, 1);
		// oneLottoStatistics.put(3, 1);
		// oneLottoStatistics.put(4, 0);
		// oneLottoStatistics.put(5, 0);

		List<RewardType> oneLottoStatistics = new ArrayList<>();
		oneLottoStatistics.add(RewardType.NOTHING);
		oneLottoStatistics.add(RewardType.THIRD);
		oneLottoStatistics.add(RewardType.FOURTH);
		oneLottoStatistics.add(RewardType.FIFTH);

		return Stream.of(
			Arguments.of(oneLottoStatistics, 1555000)
		);
	}

	@DisplayName("로또 개수와 당첨 번호를 비교한 후, 맞은 개수를 반환한다.")
	@CsvSource(value = {"1,2,3,4,5,6 : 1,2,3,4,5,6 : 6 : 1", "1,2,3,4,5,7 : 1,2,3,4,5,6 : 5 : 1"
		, "3,4,5,6,22,33 : 1,2,3,4,5,6 : 4 : 1",
		"4,5,6,7,28,42 : 1,2,3,4,5,6 : 3 : 1"}, delimiter = ':')
	@ParameterizedTest
	public void 당첨번호_입력시_일치여부가_리턴된다(String lottoNumber, String winningNumber,
		int expectedMatchType, int matchCount) {

		//given
		List<LottoNumber> lottoNumbersBeforeList = Arrays.stream(lottoNumber.split(","))
			.map(Integer::parseInt)
			.map(LottoNumber::new)
			.collect(Collectors.toList());
		LottoTicket mockTicket = new LottoTicket(lottoNumbersBeforeList);
		LottoTickets mockTickets = new LottoTickets(Collections.singletonList(mockTicket));

		//when
		List<Integer> winningNumbersBeforeList = Arrays.stream(winningNumber.split(","))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		WinningNumbers winningNumbers = new WinningNumbers(winningNumbersBeforeList);
		LottoResult lottoResult = new WinningService().calculateLottoMatches(mockTickets, winningNumbers);

		//then
		assertThat(lottoResult.getLottoStatistics().get(expectedMatchType))
			.isEqualTo(matchCount);
	}

	@DisplayName("보너스 볼을 입력했을 때 게임에서 유효한 보너스 볼일 지 검증한다.")
	@CsvSource(value = {"1,2,3,4,5,6 : 6 : true", "1,2,3,4,5,7 : 7 : true"
		, "3,4,5,6,22,33 : 44 : false",
		"4,5,6,7,28,42 : 23 : false"}, delimiter = ':')
	@ParameterizedTest
	public void 보너스볼_입력시_유효한지_확인한다(String lottoNumber, int bonusBallValue, boolean bonusBallValidity) {

		//given
		List<LottoNumber> lottoNumbersBeforeList = Arrays.stream(lottoNumber.split(","))
			.map(Integer::parseInt)
			.map(LottoNumber::new)
			.collect(Collectors.toList());
		LottoTicket mockTicket = new LottoTicket(lottoNumbersBeforeList);
		LottoTickets mockTickets = new LottoTickets(Collections.singletonList(mockTicket));

		//when
		LottoNumber bonusBall = new LottoNumber(bonusBallValue);

		//then
		assertThat(new WinningService().isBonusBall(mockTickets, bonusBall)).isEqualTo(bonusBallValidity);
	}

	@DisplayName("로또 통계에 따라 당첨 타입과 당첨 금액을 활용하여 최종 수익을 계산한다.")
	@MethodSource("lottoStatisticsMock")
	@ParameterizedTest
	void 로또_통계에_따라_최종_수익을_계산한다(List<RewardType> lottoStatistics, int profit) {
		assertThat(new WinningService().calculateProfit(lottoStatistics).getValue()).isEqualTo(profit);
	}
}
