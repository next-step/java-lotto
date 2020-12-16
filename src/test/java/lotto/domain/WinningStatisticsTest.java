package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WinningStatisticsTest {

	LottoTickets lottoTickets;

	@BeforeEach
	void setUp() {
		LottoNumber lottoNumber1 = new LottoNumber(1);
		LottoNumber lottoNumber2 = new LottoNumber(12);
		LottoNumber lottoNumber3 = new LottoNumber(13);
		LottoNumber lottoNumber4 = new LottoNumber(14);
		LottoNumber lottoNumber5 = new LottoNumber(15);
		LottoNumber lottoNumber6 = new LottoNumber(16);

		List<LottoNumber> lottoNumbers = new ArrayList<>();
		lottoNumbers.add(lottoNumber1);
		lottoNumbers.add(lottoNumber2);
		lottoNumbers.add(lottoNumber3);
		lottoNumbers.add(lottoNumber4);
		lottoNumbers.add(lottoNumber5);
		lottoNumbers.add(lottoNumber6);

		LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

		List<LottoTicket> customLottoTickets = new ArrayList<>();
		customLottoTickets.add(lottoTicket);
		lottoTickets = new LottoTickets(customLottoTickets);
	}

	@Order(1)
	@DisplayName("1. 3개일치")
	@Test
	public void matchThree() {
		String winningNumber = "1, 12, 13, 24, 25, 26";
		WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumber);

		WinningStatistics winningStatistics = new WinningStatistics(lottoTickets, winningLottoNumbers.getLottoTicket());
		assertThat(winningStatistics.getPrizeResult().get(Prize.THREE)).isEqualTo(1);
		assertThat(winningStatistics.getWinningSummary()).isEqualTo(WinningStatistics.parseWinningSummaryFormat(5.0));

	}

	@Order(2)
	@DisplayName("2. 4개일치")
	@Test
	public void matchFour() {
		String winningNumber = "1, 12, 13, 14, 25, 26";
		WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumber);

		WinningStatistics winningStatistics = new WinningStatistics(lottoTickets, winningLottoNumbers.getLottoTicket());
		assertThat(winningStatistics.getPrizeResult().get(Prize.FOUR)).isEqualTo(1);
		assertThat(winningStatistics.getWinningSummary()).isEqualTo(WinningStatistics.parseWinningSummaryFormat(50.0));
	}

	@Order(3)
	@DisplayName("3. 5개일치")
	@Test
	public void matchFive() {
		String winningNumber = "1, 12, 13, 14, 15, 26";
		WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumber);

		WinningStatistics winningStatistics = new WinningStatistics(lottoTickets, winningLottoNumbers.getLottoTicket());
		assertThat(winningStatistics.getPrizeResult().get(Prize.FIVE)).isEqualTo(1);
		assertThat(winningStatistics.getWinningSummary()).isEqualTo(WinningStatistics.parseWinningSummaryFormat(1500.0));
	}

	@Order(4)
	@DisplayName("4. 6개일치")
	@Test
	public void matchSix() {
		String winningNumber = "1, 12, 13, 14, 15, 16";
		WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumber);

		WinningStatistics winningStatistics = new WinningStatistics(lottoTickets, winningLottoNumbers.getLottoTicket());
		assertThat(winningStatistics.getPrizeResult().get(Prize.SIX)).isEqualTo(1);
		assertThat(winningStatistics.getWinningSummary()).isEqualTo(WinningStatistics.parseWinningSummaryFormat(2000000.0));
	}

	@Order(5)
	@DisplayName("5. 0개일치")
	@Test
	public void inputCannotDuplicate() {
		String winningNumber = "21, 22, 23, 24, 25, 26";
		WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumber);

		WinningStatistics winningStatistics = new WinningStatistics(lottoTickets, winningLottoNumbers.getLottoTicket());
		assertThat(winningStatistics.getPrizeResult().get(Prize.NONE)).isEqualTo(1);
	}
}
