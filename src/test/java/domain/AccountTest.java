package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

	@DisplayName("제대로 복권의 수를 반환하는지 확인하는 테스트")
	@Test
	void test_return_lotto() {
		Account account = new Account(14_000);
		Integer manualLottoCount = 3;
		assertThat(account.lottoCountByUnit(manualLottoCount)).isEqualTo(11);
	}

	@DisplayName("수익률을 제대로 반환하는지 확인하는 테스트")
	@Test
	void test_return_yield() {
		Account account = new Account(10_000);
		double lottoYield = account.lottoYield(Rank.THIRD.getAmount());
		assertThat(lottoYield).isEqualTo(150.0);
	}
}
