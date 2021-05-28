package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.utils.LottoGenerator;

public class LottoUserTest {

	LottoUser user;

	@BeforeEach
	void setUpUser() {
		user = new LottoUser();
	}

	@Test
	@DisplayName("유저 생성 테스트")
	public void createLottoUser() {
		assertThat(user).isNotNull();
	}

	@ParameterizedTest
	@CsvSource(value = {"10000,10,9", "15000,15,14", "13500,13,12", "400000,400,399"}, delimiter = ',')
	@DisplayName("로또 구매 테스트")
	public void buyLotto(int money, int lottoCount, int autoLottoCount) {
		user = new LottoUser();
		Lottos manualLottos = new Lottos();
		manualLottos.addLotto(LottoGenerator.generate());
		user.buyLottos(manualLottos, money);
		LottoPurchaseHistory purchaseHistory = user.getLottoPurchaseHistory();
		assertThat(user.getLottoCount()).isEqualTo(lottoCount);
		assertThat(purchaseHistory.getManualLottoCount()).isEqualTo(1);
		assertThat(purchaseHistory.getAutoLottoCount()).isEqualTo(autoLottoCount);
	}
}
