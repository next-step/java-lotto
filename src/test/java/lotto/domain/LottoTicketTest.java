package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.exception.InvalidLottoNumbersSizeException;

class LottoTicketTest {

	@DisplayName("로또 1장은 중복되지 않는 6개의 번호를 갖는다.")
	@Test
	void lottoTicketHasNonDuplicateSixNumber() {
		LottoMachine lottoMachine = new LottoMachine();
		LottoTicket lottoTicket = LottoTicket.from(lottoMachine.pickRandomNumbers());
		assertThat(lottoTicket.getNumbers()).hasSize(6).doesNotHaveDuplicates();
	}

	@DisplayName("로또 1장 생성 시 번호가 6개가 아니면 InvalidLottoNumbersSizeException 예외가 발생한다.")
	@MethodSource("invalidLottoNumbersSizeArguments")
	@ParameterizedTest
	void invalidLottoNumbersSize(List<Integer> lottoNumbers) {
		assertThatThrownBy(() -> LottoTicket.from(lottoNumbers))
			.isInstanceOf(InvalidLottoNumbersSizeException.class);
	}

	@DisplayName("지난 주 당첨 번호로 로또를 생성한다.")
	@MethodSource("winningLottoNumbersArguments")
	@ParameterizedTest
	void winningLottoTicket(WinningLottoNumbers winningNumbers, List<Integer> numbers) {
		LottoTicket winningLottoTicket = LottoTicket.from(winningNumbers);
		assertThat(winningLottoTicket.getNumbers()).containsAll(numbers);
	}

	@DisplayName("구매한 로또와 지난 주 당첨 번호를 갖는 로또를 비교한다.")
	@MethodSource("compareTwoLottoTicketsArguments")
	@ParameterizedTest
	void compareTwoLottoTickets(List<Integer> boughtLottoNumbers, List<Integer> winningLottoNumbers, LottoPrize prize) {
		LottoTicket boughtLottoTicket = LottoTicket.from(boughtLottoNumbers);
		LottoTicket winningLottoTicket = LottoTicket.from(winningLottoNumbers);
		assertThat(boughtLottoTicket.compareTo(winningLottoTicket)).isEqualTo(prize);
	}

	private static Stream<Arguments> invalidLottoNumbersSizeArguments() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
		);
	}

	private static Stream<Arguments> winningLottoNumbersArguments() {
		return Stream.of(
			Arguments.of(WinningLottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6)), Arrays.asList(1, 2, 3, 4, 5, 6))
		);
	}

	private static Stream<Arguments> compareTwoLottoTicketsArguments() {
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		return Stream.of(
			Arguments.of(Arrays.asList(7, 8, 9, 10, 11, 12), winningNumbers, LottoPrize.NO_NUMBERS),
			Arguments.of(Arrays.asList(1, 7, 8, 9, 10, 11), winningNumbers, LottoPrize.ONE_NUMBER),
			Arguments.of(Arrays.asList(1, 2, 7, 8, 9, 10), winningNumbers, LottoPrize.TWO_NUMBERS),
			Arguments.of(Arrays.asList(1, 2, 3, 7, 8, 9), winningNumbers, LottoPrize.THREE_NUMBERS),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 8, 9), winningNumbers, LottoPrize.FOUR_NUMBERS),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 9), winningNumbers, LottoPrize.FIVE_NUMBERS),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), winningNumbers, LottoPrize.ALL_NUMBERS)
		);
	}

}