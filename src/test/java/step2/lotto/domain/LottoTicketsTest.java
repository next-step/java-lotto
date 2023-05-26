package step2.lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import step2.lotto.LottoFixedNumberGenerator;
import step2.lotto.LottoRandomNumberGenerator;

public class LottoTicketsTest {

	public static final int LOTTO_COUNT = 3;

	@Test
	void 생성_테스트() {
		LottoTickets lottoTickets = LottoTickets.create();

		assertThat(lottoTickets)
			.isInstanceOf(LottoTickets.class);
	}

	@Test
	void 로또_티켓_추가_테스트() {
		LottoTickets lottoTickets = LottoTickets.create();

		IntStream.range(0, LOTTO_COUNT).forEach(i ->
			lottoTickets.add(LottoTicket.fromLottoNumberGenerator(LottoRandomNumberGenerator.create()))
		);

		assertThat(lottoTickets.getSize())
			.isEqualTo(LOTTO_COUNT);
	}

	@ParameterizedTest
	@ValueSource(ints = { 0, 1, 2, 3, 4, 5, 6 })
	void 당첨_번호_일치_테스트(int count) {
		// 6~11, 5~10, ... , 0~5
		int startIndex = LottoTicket.LOTTO_NUMBER_LENGTH - count;

		LottoTickets lottoTickets = LottoTickets.from(
			IntStream.range(0, LOTTO_COUNT)
				.mapToObj(i -> LottoTicket.fromLottoNumberGenerator(LottoFixedNumberGenerator.createSequential(startIndex)))
				.collect(Collectors.toList())
		);

		// 0~5
		LottoTicket lottoTicket = LottoTicket.fromLottoNumberGenerator(LottoFixedNumberGenerator.createSequential(0));

		assertThat(lottoTickets.countMatchedTicket(lottoTicket, count))
			.isEqualTo(LOTTO_COUNT);
	}
}
