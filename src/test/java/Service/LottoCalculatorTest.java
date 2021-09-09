package Service;

import Service.LottoCalculator;
import domain.Account;
import domain.Lotto;
import domain.Number;
import domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCalculatorTest {

	private LottoCalculator calculator;
	private Lotto winningLotto;

	@BeforeEach
	void setUp() {
		calculator = new LottoCalculator();
		winningLotto = new Lotto(Arrays.asList(new Number(1),new Number(2),new Number(3), new Number(4), new Number(5),
						new Number(6)));
	}

	@DisplayName("Rank가 포함된 Container에 제대로 Rank가 있는지 확인하는 테스트")
	@Test
	void test_container() {
		Lotto firstLotto = new Lotto(Arrays.asList(new Number(1),new Number(2),new Number(3), new Number(4), new Number(5),
						new Number(8)));
		Lotto secondLotto = new Lotto(Arrays.asList(new Number(1),new Number(2),new Number(3), new Number(4), new Number(5),
						new Number(7)));
		List<Lotto> lottos = Arrays.asList(firstLotto, secondLotto);
		Number bonusNumber = new Number(7);
		List<Rank> result = calculator.getResult(lottos, winningLotto, bonusNumber);
		assertThat(result.get(0)).isEqualTo(Rank.THIRD);
		assertThat(result.get(1)).isEqualTo(Rank.SECOND);
	}

	@DisplayName("금액에 맞는 로또를 얼마나 살 수 있는 지 확인하는 테스트")
	@Test
	void test_account() {
		Account account = new Account(12_500);
		assertThat(calculator.getLottoCount(account)).isEqualTo(12);
	}
}
