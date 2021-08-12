package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PrizeTest {

	@ParameterizedTest
	@DisplayName("당첨수에 따라 결과 및 금액을 알수있다.")
	@CsvSource(value = {"3,5000,false", "4,50000,false", "5,1500000,false", "5,3000000,true", "6,2000000000,false"})
	public void returnPrizeMoney(int countOfMatch, int winningMoney, boolean matchBonus) {
		Prize result = Prize.getWinnersStatus(countOfMatch, matchBonus);

		assertThat(result.getWinningMoney()).isEqualTo(winningMoney);
	}
}
