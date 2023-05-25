package step2.lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import step2.lotto.LottoFixedNumberGenerator;

public class LottoStatisticTest {

	private LottoFixedNumberGenerator answerLottoGenerator = LottoFixedNumberGenerator.createSequential(0);
	private LottoFixedNumberGenerator wrongLottoGenerator = LottoFixedNumberGenerator.createSequential(100);


	@Test
	void 생성() {
		LottoWinningStatistic lottoStatistic = new LottoWinningStatistic(LottoTickets.create());

		assertThat(lottoStatistic)
			.isInstanceOf(LottoWinningStatistic.class);
	}

	@Test
	void 로또_번호_일치하는_개수() {
		LottoTicket answerLottoTicket = LottoTicket.from(answerLottoGenerator);

		Map<Integer, Integer> matchToCount = new HashMap<>(){
			{
				put(0, 1); // 0개 일치, 100개
				put(6, 2); // 6개 일치, 1개
				put(5, 3); // 5개 일치, 2개
				put(4, 4); // 4개 일치, 3개
				put(3, 5); // 3개 일치, 4개
			}
		};

		LottoTickets lottoTickets = getLottoTickets(matchToCount);

		LottoWinningStatistic lottoWinningStatistic = LottoWinningStatistic.from(lottoTickets);
		LottoWinningStatisticDto lottoWinningStatisticDto = lottoWinningStatistic.calculateStatistic(answerLottoTicket);

		assertAll(
			() -> assertThat(lottoWinningStatisticDto.getSixMatch()).isEqualTo(2),
			() -> assertThat(lottoWinningStatisticDto.getFiveMatch()).isEqualTo(3),
			() -> assertThat(lottoWinningStatisticDto.getFourMatch()).isEqualTo(4),
			() -> assertThat(lottoWinningStatisticDto.getThreeMatch()).isEqualTo(5)
		);
	}

	@Test
	void 수익률() {
		LottoFixedNumberGenerator answerLottoGenerator = LottoFixedNumberGenerator.createSequential(0);
		LottoTicket answerLottoTicket = LottoTicket.from(answerLottoGenerator);

		Map<Integer, Integer> matchToCount = new HashMap<>(){
			{
			put(0, 100); // 0개 일치, 100개
			put(6, 1); // 6개 일치, 1개
			put(5, 2); // 5개 일치, 2개
			put(4, 3); // 4개 일치, 3개
			put(3, 4); // 3개 일치, 4개
			}
		};

		LottoTickets lottoTickets = getLottoTickets(matchToCount);

		LottoWinningStatistic lottoWinningStatistic = LottoWinningStatistic.from(lottoTickets);
		LottoWinningStatisticDto lottoWinningStatisticDto = lottoWinningStatistic.calculateStatistic(answerLottoTicket);

		assertThat(lottoWinningStatisticDto.getProfitRate()).isEqualTo(18210.64);
	}

	private LottoTickets getLottoTickets(Map<Integer, Integer> matchToCount) {
		List<LottoTicket> ticketList = new ArrayList<>();


		for (Map.Entry entry : matchToCount.entrySet()) {
			int count = (int)entry.getValue();
			int match = (int)entry.getKey();

			int startIndex = LottoFixedNumberGenerator.LOTTO_NUMBER_LENGTH - match;

			extracted(ticketList, count, match, startIndex);
		}

		LottoTickets lottoTickets = LottoTickets.from(ticketList);
		return lottoTickets;
	}

	private void extracted(List<LottoTicket> ticketList, int count, int match, int startIndex) {
		LottoTicket wrongLottoTicket = LottoTicket.from(wrongLottoGenerator);

		for (int i = 0; i < count; i++) {
			if (match == 0) {
				ticketList.add(wrongLottoTicket);
				continue;
			}

			LottoTicket lottoTicket = LottoTicket.from(LottoFixedNumberGenerator.createSequential(startIndex).shuffle());
			ticketList.add(lottoTicket);
		}
	}
}
