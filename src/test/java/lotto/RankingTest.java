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
import lotto.domain.Ranking;
import lotto.domain.RankingResult;

public class RankingTest {
	LastWeekWinnerNumber lastWeekWinnerNumber = new LastWeekWinnerNumber("2,3,15,25,35,45", new LottoNumber(33));

	Lotto firstGrade = new Lotto(() -> {
		List<LottoNumber> gameNumberList = new ArrayList<>();
		gameNumberList.add(new LottoNumber(2));
		gameNumberList.add(new LottoNumber(3));
		gameNumberList.add(new LottoNumber(15));
		gameNumberList.add(new LottoNumber(25));
		gameNumberList.add(new LottoNumber(35));
		gameNumberList.add(new LottoNumber(45));
		return gameNumberList;
	});

	Lotto secondGrade = new Lotto(() -> {
		List<LottoNumber> gameNumberList = new ArrayList<>();
		gameNumberList.add(new LottoNumber(2));
		gameNumberList.add(new LottoNumber(3));
		gameNumberList.add(new LottoNumber(15));
		gameNumberList.add(new LottoNumber(25));
		gameNumberList.add(new LottoNumber(33));
		gameNumberList.add(new LottoNumber(35));
		return gameNumberList;
	});

	Lotto secondGrade2 = new Lotto(() -> {
		List<LottoNumber> gameNumberList = new ArrayList<>();
		gameNumberList.add(new LottoNumber(2));
		gameNumberList.add(new LottoNumber(3));
		gameNumberList.add(new LottoNumber(15));
		gameNumberList.add(new LottoNumber(25));
		gameNumberList.add(new LottoNumber(33));
		gameNumberList.add(new LottoNumber(45));
		return gameNumberList;
	});

	Lotto thirdGrade = new Lotto(() -> {
		List<LottoNumber> gameNumberList = new ArrayList<>();
		gameNumberList.add(new LottoNumber(2));
		gameNumberList.add(new LottoNumber(3));
		gameNumberList.add(new LottoNumber(15));
		gameNumberList.add(new LottoNumber(25));
		gameNumberList.add(new LottoNumber(35));
		gameNumberList.add(new LottoNumber(44));
		return gameNumberList;
	});

	Lotto fourthGrade = new Lotto(() -> {
		List<LottoNumber> gameNumberList = new ArrayList<>();
		gameNumberList.add(new LottoNumber(2));
		gameNumberList.add(new LottoNumber(3));
		gameNumberList.add(new LottoNumber(15));
		gameNumberList.add(new LottoNumber(24));
		gameNumberList.add(new LottoNumber(34));
		gameNumberList.add(new LottoNumber(45));
		return gameNumberList;
	});

	Lotto fifthGrade = new Lotto(() -> {
		List<LottoNumber> gameNumberList = new ArrayList<>();
		gameNumberList.add(new LottoNumber(2));
		gameNumberList.add(new LottoNumber(3));
		gameNumberList.add(new LottoNumber(15));
		gameNumberList.add(new LottoNumber(24));
		gameNumberList.add(new LottoNumber(34));
		gameNumberList.add(new LottoNumber(41));
		return gameNumberList;
	});

	@Test
	@DisplayName("1등 6개 일치 테스트 : 1장")
	void rankingTest_6개일치1장() {
		Lotteries lotteries = new Lotteries(firstGrade);

		RankingResult rankingResult = lotteries.calculateRanking(lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.FIRST)).isEqualTo(1);

	}

	@Test
	@DisplayName("1등 6개 일치 테스트 : 2장")
	void rankingTest_6개일치2장() {
		Lotteries lotteries = new Lotteries(firstGrade, firstGrade);

		RankingResult rankingResult = lotteries.calculateRanking(lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.FIRST)).isEqualTo(2);

	}

	@Test
	@DisplayName("2등 5개,보너스 일치 테스트 : 1장")
	void rankingTest_5개_bonus_일치1장() {
		Lotteries lotteries = new Lotteries(secondGrade);

		RankingResult rankingResult = lotteries.calculateRanking(lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.SECOND)).isEqualTo(1);
	}

	@Test
	@DisplayName("2등 5개,보너스 일치 테스트 : 2장")
	void rankingTest_5개_bonus_일치2장() {
		Lotteries lotteries = new Lotteries(secondGrade, secondGrade2);

		RankingResult rankingResult = lotteries.calculateRanking(lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.SECOND)).isEqualTo(2);
	}

	@Test
	@DisplayName("3등 5개 일치 테스트 : 1장")
	void rankingTest_5개일치1장() {
		Lotteries lotteries = new Lotteries(thirdGrade);

		RankingResult rankingResult = lotteries.calculateRanking(lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.THIRD)).isEqualTo(1);
	}

	@Test
	@DisplayName("3등 5개 일치 테스트 : 2장")
	void rankingTest_5개일치2장() {
		Lotteries lotteries = new Lotteries(thirdGrade, thirdGrade);

		RankingResult rankingResult = lotteries.calculateRanking(lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.THIRD)).isEqualTo(2);
	}

	@Test
	@DisplayName("4등 4개 일치 테스트")
	void rankingTest_4개일치() {
		Lotteries lotteries = new Lotteries(fourthGrade);

		RankingResult rankingResult = lotteries.calculateRanking(lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.FOURTH)).isEqualTo(1);
	}

	@Test
	@DisplayName("5등 3개 일치 테스트")
	void rankingTest_3개일치() {
		Lotteries lotteries = new Lotteries(fifthGrade);

		RankingResult rankingResult = lotteries.calculateRanking(lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.FIFTH)).isEqualTo(1);
	}

	@Test
	@DisplayName("valueOf 검증 테스트")
	void valueOfTest() {
		assertThat(Ranking.valueOf(6, false)).isEqualTo(Ranking.FIRST);
		assertThat(Ranking.valueOf(5, true)).isEqualTo(Ranking.SECOND);
		assertThat(Ranking.valueOf(5, false)).isEqualTo(Ranking.THIRD);
		assertThat(Ranking.valueOf(4, false)).isEqualTo(Ranking.FOURTH);
		assertThat(Ranking.valueOf(3, false)).isEqualTo(Ranking.FIFTH);
		assertThat(Ranking.valueOf(2, false)).isEqualTo(Ranking.MISS);
		assertThat(Ranking.valueOf(1, false)).isEqualTo(Ranking.MISS);
		assertThat(Ranking.valueOf(0, false)).isEqualTo(Ranking.MISS);

	}

}
