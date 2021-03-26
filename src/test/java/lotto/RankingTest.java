package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LastWeekWinnerNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoGames;
import lotto.domain.LottoNumber;
import lotto.domain.Ranking;
import lotto.domain.RankingResult;

public class RankingTest {
	LastWeekWinnerNumber lastWeekWinnerNumber = new LastWeekWinnerNumber("2,3,15,25,35,45");

	Lotto lottoSixMatch = new Lotto(() -> {
		List<LottoNumber> gameNumberList = new ArrayList<>();
		gameNumberList.add(new LottoNumber(2));
		gameNumberList.add(new LottoNumber(3));
		gameNumberList.add(new LottoNumber(15));
		gameNumberList.add(new LottoNumber(25));
		gameNumberList.add(new LottoNumber(35));
		gameNumberList.add(new LottoNumber(45));
		return gameNumberList;
	});

	Lotto lottoFiveMatch1 = new Lotto(() -> {
		List<LottoNumber> gameNumberList = new ArrayList<>();
		gameNumberList.add(new LottoNumber(2));
		gameNumberList.add(new LottoNumber(3));
		gameNumberList.add(new LottoNumber(15));
		gameNumberList.add(new LottoNumber(25));
		gameNumberList.add(new LottoNumber(35));
		gameNumberList.add(new LottoNumber(44));
		return gameNumberList;
	});

	Lotto lottoFiveMatch2 = new Lotto(() -> {
		List<LottoNumber> gameNumberList = new ArrayList<>();
		gameNumberList.add(new LottoNumber(2));
		gameNumberList.add(new LottoNumber(3));
		gameNumberList.add(new LottoNumber(15));
		gameNumberList.add(new LottoNumber(25));
		gameNumberList.add(new LottoNumber(34));
		gameNumberList.add(new LottoNumber(45));
		return gameNumberList;
	});

	Lotto lottoFourMatch = new Lotto(() -> {
		List<LottoNumber> gameNumberList = new ArrayList<>();
		gameNumberList.add(new LottoNumber(2));
		gameNumberList.add(new LottoNumber(3));
		gameNumberList.add(new LottoNumber(15));
		gameNumberList.add(new LottoNumber(24));
		gameNumberList.add(new LottoNumber(34));
		gameNumberList.add(new LottoNumber(45));
		return gameNumberList;
	});

	Lotto lottoThreeMatch = new Lotto(() -> {
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
	@DisplayName("6개 일치 테스트 : 1장")
	void rankingTest_6개일치1장() {
		LottoGames lottoGames = new LottoGames(lottoSixMatch);

		RankingResult rankingResult = new RankingResult();
		rankingResult.calculate(lottoGames, lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.SIX)).isEqualTo(1);

	}

	@Test
	@DisplayName("6개 일치 테스트 : 2장")
	void rankingTest_6개일치2장() {
		LottoGames lottoGames = new LottoGames(lottoSixMatch, lottoSixMatch);

		RankingResult rankingResult = new RankingResult();
		rankingResult.calculate(lottoGames, lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.SIX)).isEqualTo(2);

	}

	@Test
	@DisplayName("5개 일치 테스트 : 1장")
	void rankingTest_5개일치1장() {
		LottoGames lottoGames = new LottoGames(lottoFiveMatch1);

		RankingResult rankingResult = new RankingResult();
		rankingResult.calculate(lottoGames, lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.FIVE)).isEqualTo(1);
	}

	@Test
	@DisplayName("5개 일치 테스트 : 2장")
	void rankingTest_5개일치2장() {
		LottoGames lottoGames = new LottoGames(lottoFiveMatch1, lottoFiveMatch2);

		RankingResult rankingResult = new RankingResult();
		rankingResult.calculate(lottoGames, lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.FIVE)).isEqualTo(2);
	}

	@Test
	@DisplayName("4개 일치 테스트")
	void rankingTest_4개일치() {
		LottoGames lottoGames = new LottoGames(lottoFourMatch);

		RankingResult rankingResult = new RankingResult();
		rankingResult.calculate(lottoGames, lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.FOUR)).isEqualTo(1);
	}

	@Test
	@DisplayName("3개 일치 테스트")
	void rankingTest_3개일치() {
		LottoGames lottoGames = new LottoGames(lottoThreeMatch);

		RankingResult rankingResult = new RankingResult();
		rankingResult.calculate(lottoGames, lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.THREE)).isEqualTo(1);
	}

}
