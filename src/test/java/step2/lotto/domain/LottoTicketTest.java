package step2.lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import step2.lotto.LottoFixedNumberGenerator;
import step2.lotto.LottoNumberGenerator;
import step2.lotto.LottoRandomNumberGenerator;

public class LottoTicketTest {
	private LottoNumberGenerator fixedLottoNumberGenerator = LottoFixedNumberGenerator.createSequential(0);

	private LottoTicket answerLottoTicket = LottoTicket.fromLottoNumberGenerator(fixedLottoNumberGenerator);

	private LottoRandomNumberGenerator lottoRandomNumberGenerator = LottoRandomNumberGenerator.create();

	@Test
	void 생성_테스트() {
		LottoTicket lotto = LottoTicket.fromLottoNumberGenerator(lottoRandomNumberGenerator);

		assertAll(
			() -> assertThat(lotto).isInstanceOf(LottoTicket.class)
		);
	}

	@Test
	void 번호_생성_테스트() {
		LottoNumberGenerator unmatchedLottoNumberGenerator = LottoFixedNumberGenerator.createSequential(1);

		LottoTicket answerLotto = LottoTicket.fromLottoNumberGenerator(fixedLottoNumberGenerator);
		LottoTicket wrongLotto = LottoTicket.fromLottoNumberGenerator(unmatchedLottoNumberGenerator);

		assertAll(
			() -> assertThat(answerLotto.countMatch(answerLottoTicket)).isEqualTo(6),
			() -> assertThat(wrongLotto.countMatch(answerLottoTicket)).isEqualTo(5)
		);
	}

	@Test
	void 번호_개수는_범위를_넘을_수_없다() {
		assertThatThrownBy(() -> {
			LottoNumberGenerator wrongLottoNumberGenerator = LottoFixedNumberGenerator.from(
				IntStream.range(0, LottoTicket.LOTTO_NUMBER_LENGTH + 1).boxed().collect(Collectors.toList())
			);

			LottoTicket.fromLottoNumberGenerator(wrongLottoNumberGenerator);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 번호들은_중복될_수_없다() {
		List<Integer> numbers = Stream.generate(() -> 1)
			.limit(LottoTicket.LOTTO_NUMBER_LENGTH)
			.collect(Collectors.toList());

		assertThatThrownBy(() -> {
			LottoNumberGenerator wrongLottoNumberGenerator = LottoFixedNumberGenerator.from(numbers);

			LottoTicket.fromLottoNumberGenerator(wrongLottoNumberGenerator);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}

