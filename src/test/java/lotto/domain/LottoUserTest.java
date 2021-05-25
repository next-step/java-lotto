package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoUserTest {

	LottoUser user;

	@BeforeEach
	void setUpUser() {
		user = new LottoUser(10000L);
	}

	@Test
	@DisplayName("유저 생성 테스트")
	public void createLottoUser() {
		assertThat(user).isNotNull();
	}

	@ParameterizedTest
	@CsvSource(value = {"10000,10", "15000,15", "13500,13", "400000,400"}, delimiter = ',')
	@DisplayName("로또 구매 테스트")
	public void buyLotto(int price, int lottoCount) {
		user.buyGenerateLottos();
		assertThat(user.getLottoCount()).isEqualTo(lottoCount);
	}

}
