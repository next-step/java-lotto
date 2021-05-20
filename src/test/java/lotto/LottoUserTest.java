package lotto;

import static org.assertj.core.api.Assertions.*;

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
		assertThat(user.userLottos()).isNotNull();
	}

	@Test
	public void buyLottoTest() throws Exception {
		user.buyLottos(10500);
		assertThat(user.userLottos().size()).isEqualTo(10);
	}
}
