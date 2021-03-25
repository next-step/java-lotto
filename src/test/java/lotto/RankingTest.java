package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LastWeekWinnerNumber;
import lotto.domain.LottoGame;
import lotto.domain.LottoGameList;
import lotto.domain.LottoNumber;
import lotto.domain.Ranking;
import lotto.domain.RankingResult;

public class RankingTest {
	LastWeekWinnerNumber lastWeekWinnerNumber = new LastWeekWinnerNumber("2,3,15,25,35,45");

	LottoGame lottoGameSixMatch = new LottoGame(() -> {
		List<LottoNumber> gameNumberList = new ArrayList<>();
		gameNumberList.add(new LottoNumber(2));
		gameNumberList.add(new LottoNumber(3));
		gameNumberList.add(new LottoNumber(15));
		gameNumberList.add(new LottoNumber(25));
		gameNumberList.add(new LottoNumber(35));
		gameNumberList.add(new LottoNumber(45));
		return gameNumberList;
	});

	LottoGame lottoGameFiveMatch1 = new LottoGame(() -> {
		List<LottoNumber> gameNumberList = new ArrayList<>();
		gameNumberList.add(new LottoNumber(2));
		gameNumberList.add(new LottoNumber(3));
		gameNumberList.add(new LottoNumber(15));
		gameNumberList.add(new LottoNumber(25));
		gameNumberList.add(new LottoNumber(35));
		gameNumberList.add(new LottoNumber(44));
		return gameNumberList;
	});

	LottoGame lottoGameFiveMatch2 = new LottoGame(() -> {
		List<LottoNumber> gameNumberList = new ArrayList<>();
		gameNumberList.add(new LottoNumber(2));
		gameNumberList.add(new LottoNumber(3));
		gameNumberList.add(new LottoNumber(15));
		gameNumberList.add(new LottoNumber(25));
		gameNumberList.add(new LottoNumber(34));
		gameNumberList.add(new LottoNumber(45));
		return gameNumberList;
	});

	LottoGame lottoGameFourMatch = new LottoGame(() -> {
		List<LottoNumber> gameNumberList = new ArrayList<>();
		gameNumberList.add(new LottoNumber(2));
		gameNumberList.add(new LottoNumber(3));
		gameNumberList.add(new LottoNumber(15));
		gameNumberList.add(new LottoNumber(24));
		gameNumberList.add(new LottoNumber(34));
		gameNumberList.add(new LottoNumber(45));
		return gameNumberList;
	});

	LottoGame lottoGameThreeMatch = new LottoGame(() -> {
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
		LottoGameList lottoGameList = new LottoGameList();
		lottoGameList.addLottoGame(lottoGameSixMatch);

		RankingResult rankingResult = new RankingResult();
		rankingResult.calculate(lottoGameList, lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.SIX)).isEqualTo(1);

	}

	@Test
	@DisplayName("6개 일치 테스트 : 2장")
	void rankingTest_6개일치2장() {
		LottoGameList lottoGameList = new LottoGameList();
		lottoGameList.addLottoGame(lottoGameSixMatch);
		lottoGameList.addLottoGame(lottoGameSixMatch);

		RankingResult rankingResult = new RankingResult();
		rankingResult.calculate(lottoGameList, lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.SIX)).isEqualTo(2);

	}

	@Test
	@DisplayName("5개 일치 테스트 : 1장")
	void rankingTest_5개일치1장() {
		LottoGameList lottoGameList = new LottoGameList();
		lottoGameList.addLottoGame(lottoGameFiveMatch1);

		RankingResult rankingResult = new RankingResult();
		rankingResult.calculate(lottoGameList, lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.FIVE)).isEqualTo(1);
	}

	@Test
	@DisplayName("5개 일치 테스트 : 2장")
	void rankingTest_5개일치2장() {
		LottoGameList lottoGameList = new LottoGameList();
		lottoGameList.addLottoGame(lottoGameFiveMatch1);
		lottoGameList.addLottoGame(lottoGameFiveMatch2);

		RankingResult rankingResult = new RankingResult();
		rankingResult.calculate(lottoGameList, lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.FIVE)).isEqualTo(2);
	}

	@Test
	@DisplayName("4개 일치 테스트")
	void rankingTest_4개일치() {
		LottoGameList lottoGameList = new LottoGameList();
		lottoGameList.addLottoGame(lottoGameFourMatch);

		RankingResult rankingResult = new RankingResult();
		rankingResult.calculate(lottoGameList, lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.FOUR)).isEqualTo(1);
	}

	@Test
	@DisplayName("3개 일치 테스트")
	void rankingTest_3개일치() {
		LottoGameList lottoGameList = new LottoGameList();
		lottoGameList.addLottoGame(lottoGameThreeMatch);

		RankingResult rankingResult = new RankingResult();
		rankingResult.calculate(lottoGameList, lastWeekWinnerNumber);
		assertThat(rankingResult.getResult().get(Ranking.THREE)).isEqualTo(1);
	}
}
