package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

	private Lotto winningLotto;

	@BeforeEach
	void setUp() {
		winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
	}

	@DisplayName("로또의 사이지를 잘 반환하는 지 확인하는 테스트")
	@Test
	void test_lotto_size() {
		Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
		assertThat(lotto.size()).isEqualTo(6);
	}

	@DisplayName("로또가 얼마나 맞았는지 반환하는 테스트")
	@Test
	void test_lotto_match() {
		Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,7));
		Integer matchNumber = Lotto.numberOfMatches(lotto,winningLotto);
		assertThat(matchNumber).isEqualTo(5);
	}
}
