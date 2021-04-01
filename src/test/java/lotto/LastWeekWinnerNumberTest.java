package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LastWeekWinnerNumber;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.RankingResult;

public class LastWeekWinnerNumberTest {

	@Test
	@DisplayName("지난주 당첨 번호 생성")
	void lastWeekWinnerMakeTest() {
		LastWeekWinnerNumber lastWeekWinnerNumber = new LastWeekWinnerNumber("3, 1, 5, 10, 15, 25",
			new LottoNumber(33));
		assertThat(lastWeekWinnerNumber.getLastWinnerNumber().getGameNumberList()).containsExactly(new LottoNumber(1),
			new LottoNumber(3), new LottoNumber(5), new LottoNumber(10), new LottoNumber(15), new LottoNumber(25));
	}

	@Test
	@DisplayName("지난주 당첨 번호 생성 : 비정상 케이스 - 숫자가 아닌 경우")
	void lastWeekWinnerMakeInvalidTest() {
		assertThatThrownBy(() -> {
			new LastWeekWinnerNumber("3, 1, a, 10, 15, 25", new LottoNumber(33));
		}).isInstanceOf(NumberFormatException.class);
	}

	@Test
	@DisplayName("지난주 당첨 번호 생성 : 비정상 케이스 - 당첨번호가 6개가 아닌 경우")
	void lastWeekWinnerMakeInvalid2Test() {
		assertThatThrownBy(() -> {
			new LastWeekWinnerNumber("3, 1, 10, 15, 25", new LottoNumber(33));
			new LastWeekWinnerNumber("3, 1, 10, 15, 25, 30, 35", new LottoNumber(33));
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("당첨 번호 일치 갯수 테스트")
	void matchCountTest() {
		LastWeekWinnerNumber lastWeekWinnerNumber = new LastWeekWinnerNumber("1,2,3,4,5,45", new LottoNumber(33));
		int matchCount = lastWeekWinnerNumber.getMatchCount(new Lotto(() -> {
			List<LottoNumber> gameNumberList = new ArrayList<>();
			gameNumberList.add(new LottoNumber(1));
			gameNumberList.add(new LottoNumber(2));
			gameNumberList.add(new LottoNumber(3));
			gameNumberList.add(new LottoNumber(4));
			gameNumberList.add(new LottoNumber(5));
			gameNumberList.add(new LottoNumber(44));
			return gameNumberList;
		}));
		assertThat(matchCount).isEqualTo(5);
	}

	@Test
	@DisplayName("보너스 숫자 포함 여부 테스트")
	void matchBonusNumberTest() {
		LastWeekWinnerNumber lastWeekWinnerNumber = new LastWeekWinnerNumber("1,2,3,4,5,45", new LottoNumber(33));
		Lotto lotto = new Lotto(() -> {
			List<LottoNumber> gameNumberList = new ArrayList<>();
			gameNumberList.add(new LottoNumber(1));
			gameNumberList.add(new LottoNumber(2));
			gameNumberList.add(new LottoNumber(3));
			gameNumberList.add(new LottoNumber(4));
			gameNumberList.add(new LottoNumber(5));
			gameNumberList.add(new LottoNumber(33));
			return gameNumberList;
		});
		int matchCount = lastWeekWinnerNumber.getMatchCount(lotto);
		boolean matchBonusCount = lastWeekWinnerNumber.getMatchBonusCount(lotto);
		assertThat(matchCount).isEqualTo(5);
		assertThat(matchBonusCount).isEqualTo(true);
	}

	@Test
	@DisplayName("당첨번호에 보너스 숫자 포함 여부 테스트")
	void matchBonusNumberConstructTest() {
		assertThatIllegalArgumentException().isThrownBy(() ->{
			new LastWeekWinnerNumber("1,2,3,4,5,45", new LottoNumber(5));
		});

		assertThatCode(() -> {
			new LastWeekWinnerNumber("1,2,3,4,5,45", new LottoNumber(35));
		}).doesNotThrowAnyException();
	}

	@Test
	@DisplayName("숫자 포함 여부 메서드 테스트")
	void hasContainTest() {
		Lotto lotto = new Lotto(() -> {
			List<LottoNumber> gameNumberList = new ArrayList<>();
			gameNumberList.add(new LottoNumber(1));
			gameNumberList.add(new LottoNumber(2));
			gameNumberList.add(new LottoNumber(3));
			gameNumberList.add(new LottoNumber(4));
			gameNumberList.add(new LottoNumber(5));
			gameNumberList.add(new LottoNumber(33));
			return gameNumberList;
		});

		assertThat(lotto.hasContain(new LottoNumber(1))).isEqualTo(true);
		assertThat(lotto.hasContain(new LottoNumber(6))).isEqualTo(false);
	}

	@Test
	@DisplayName("수익률 테스트")
	void RorTest() {
		Lotteries lotteries = new Lotteries(
			new Lotto(() -> {
				List<LottoNumber> gameNumberList = new ArrayList<>();
				gameNumberList.add(new LottoNumber(45));
				gameNumberList.add(new LottoNumber(5));
				gameNumberList.add(new LottoNumber(15));
				gameNumberList.add(new LottoNumber(31));
				gameNumberList.add(new LottoNumber(33));
				gameNumberList.add(new LottoNumber(25));
				return gameNumberList;
			})
		);

		RankingResult rankingResult = lotteries.calculateRanking(
			new LastWeekWinnerNumber("5, 15, 31 ,34,35 ,44", new LottoNumber(33)));
		assertThat(rankingResult.getRateOfReturn(14000)).isEqualTo(0.35);
		assertThat(rankingResult.getRateOfReturn(15000)).isEqualTo(0.33);
		assertThat(rankingResult.getRateOfReturn(5000)).isEqualTo(1.00);
		assertThat(rankingResult.getRateOfReturn(1000)).isEqualTo(5.00);

	}
}
