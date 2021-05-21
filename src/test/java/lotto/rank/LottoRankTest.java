package lotto.rank;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoRankTest {

	@Test
	public void createLottoRank() {
		LottoRank firstPlace = new FirstPlace();
		assertThat(firstPlace.reward()).isEqualTo(2000000000);
		LottoRank secondPlace = new SecondPlace();
		assertThat(secondPlace.reward()).isEqualTo(1500000);
		LottoRank thirdPlace  = new ThirdPlace();
		assertThat(thirdPlace.reward()).isEqualTo(50000);
		LottoRank fourthPlace = new FourthPlace();
		assertThat(fourthPlace.reward()).isEqualTo(5000);
	}
}
