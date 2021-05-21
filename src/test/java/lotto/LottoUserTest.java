package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoUserTest {

	LottoUser user;

	@BeforeEach
	void setUpUser() {
		user = new LottoUser();
	}

	@Test
	public void createLottoUserTest() {
		assertThat(user).isNotNull();
	}

	@Test
	public void buyLottoTest() {
		user.buyLottos(10500);
		assertThat(user.lottoCount()).isEqualTo(10);
	}
}
