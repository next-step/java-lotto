package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCalculatorTest {

	private LottoCalculator calculator;
	private Lotto winningLotto;

	@BeforeEach
	void setUp() {
		calculator = new LottoCalculator();
		winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
	}

	@DisplayName("당천된 로또 갯수 컨테이너를 잘 반환하는지 확인하는 테스트")
	@Test
	void test_container() {
		Lotto firstLotto = new Lotto(Arrays.asList(1,2,3,4,5,8));
		Lotto secondLotto = new Lotto(Arrays.asList(1,2,3,4,5,7));
		List<Lotto> lottos = Arrays.asList(firstLotto, secondLotto);
		int[] result = calculator.getResult(lottos, winningLotto);
		assertThat(result[5]).isEqualTo(2);
	}
}
