package step3.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
	@Test
	void 비교() {
		assertThat(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(Lotto.ofComma("1,2,3,4,5,6"));
	}

	@Test
	void 번호수_체크() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			Lotto.ofComma("1,2,3,4,5,6,7");
		});
	}

	@Test
	void 당첨비교() {
		assertThat(Lotto.ofComma("1,2,3,4,5,6").getMatchCount(Lotto.ofComma("1,2,3,4,5,6"))).isEqualTo(6);
		assertThat(Lotto.ofComma("1,2,3,4,5,6").getMatchCount(Lotto.ofComma("1,2,3,4,5,7"))).isEqualTo(5);
		assertThat(Lotto.ofComma("1,2,3,4,5,6").getMatchCount(Lotto.ofComma("1,2,3,4,7,8"))).isEqualTo(4);
		assertThat(Lotto.ofComma("1,2,3,4,5,6").getMatchCount(Lotto.ofComma("1,2,3,7,8,9"))).isEqualTo(3);
		assertThat(Lotto.ofComma("1,2,3,4,5,6").getMatchCount(Lotto.ofComma("1,2,7,8,9,10"))).isEqualTo(2);
	}
}
