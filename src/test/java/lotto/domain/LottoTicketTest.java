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
		LottoTicket lottoTicket = LottoTicket.from(lottoMachine.pickRandomLottoNumbers());
		assertThat(lottoTicket.getNumbers()).hasSize(6).doesNotHaveDuplicates();
	}

	@DisplayName("로또 1장 생성 시 번호가 6개가 아니면 InvalidLottoNumbersSizeException 예외가 발생한다.")
	@MethodSource("invalidLottoNumbersSizeArguments")
	@ParameterizedTest
	void invalidLottoNumbersSize(List<Integer> lottoNumbers) {
		assertThatThrownBy(() -> LottoTicket.from(lottoNumbers))
			.isInstanceOf(InvalidLottoNumbersSizeException.class);
	}

	@DisplayName("두 로또 티켓을 비교하여 일치하는 번호의 개수를 구한다.")
	@Test
	void matchCount() {
		LottoTicket lottoTicket1 = LottoTicket.from(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoTicket lottoTicket2 = LottoTicket.from(Arrays.asList(1, 7, 8, 9, 10, 11));
		assertThat(lottoTicket1.matchCount(lottoTicket2)).isEqualTo(1);
	}

	@DisplayName("로또 티켓이 특정 번호를 포함하는지 확인한다.")
	@Test
	void containsBonusNumber() {
		LottoTicket lottoTicket = LottoTicket.from(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumber bonusNumber = new LottoNumber(6);
		assertThat(lottoTicket.contains(bonusNumber)).isTrue();
	}

	private static Stream<Arguments> invalidLottoNumbersSizeArguments() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
		);
	}

}