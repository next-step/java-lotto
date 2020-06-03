package lotto.collections;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

public class WinningTicketTest {

	static Stream<Arguments> SIX_ELEMENTS_OF_WINNING_NUMBERS() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
			Arguments.of(Arrays.asList(10, 11, 12, 13, 14, 15), 13)
		);
	}

	@DisplayName("지난 회차 승리 번호와 보너스 볼은 중복될 수 없다.")
	@MethodSource("SIX_ELEMENTS_OF_WINNING_NUMBERS")
	@ParameterizedTest
	void 승리_번호와_보너스_볼은_중복되지_않는다(List<Integer> winningNumberList, int bonusBall) {
		//given
		WinningNumbers winningNumbers = new WinningNumbers(winningNumberList);
		//when
		LottoNumber bonusBallNumber = new LottoNumber(bonusBall);
		//then
		assertThatThrownBy(
			() -> new WinningTicket(winningNumbers, bonusBallNumber))
			.isInstanceOf(RuntimeException.class)
			.hasMessage("로또 번호와 보너스 볼은 중복 불가합니다.");
	}

	static Stream<Arguments> WINNING_NUMBERS_AND_BONUS_BALLS() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), 38, 2000000000),
			Arguments.of(Arrays.asList(23, 25, 27, 29, 30, 42), Arrays.asList(23, 25, 26, 28, 29, 30), 3, 50000),
			Arguments.of(Arrays.asList(12, 14, 17, 18, 19, 30), Arrays.asList(12, 14, 17, 18, 19, 21), 30, 30000000),
			Arguments.of(Arrays.asList(15, 17, 19, 34, 38, 39), Arrays.asList(15, 17, 34, 23, 29, 11), 41, 5000),
			Arguments.of(Arrays.asList(10, 11, 12, 13, 15, 21), Arrays.asList(35, 39, 41, 43, 44, 45), 42, 0),
			Arguments.of(Arrays.asList(18, 19, 39, 40, 41, 45), Arrays.asList(18, 19, 39, 40, 41, 42), 43, 1500000)
		);
	}

	@DisplayName("당첨번호와 보너스 볼의 입력결과가 복합적으로 반영되어 하나의 로또티켓의 결과를 계산한다.")
	@MethodSource("WINNING_NUMBERS_AND_BONUS_BALLS")
	@ParameterizedTest
	void 당첨번호와_보너스볼이_반영된_로또결과가_계산된다(List<Integer> lottoNumberValue, List<Integer> winningNumberValue,
		int bonusBallValue, int matchReward) {
		//given
		List<LottoNumber> lottoNumbersBeforeList = lottoNumberValue.stream()
			.map(LottoNumber::new)
			.collect(Collectors.toList());
		LottoTicket mockTicket = new LottoTicket(lottoNumbersBeforeList);

		//when
		WinningNumbers winningNumbers = new WinningNumbers(winningNumberValue);
		LottoNumber bonusBall = new LottoNumber(bonusBallValue);

		//then
		RewardType rewardType = new WinningTicket(winningNumbers, bonusBall).checkLottoNumbers(mockTicket);
		assertThat(rewardType.getReward().getValue()).isEqualTo(matchReward);
	}
}
