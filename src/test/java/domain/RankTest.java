package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

	@DisplayName("랭크가 돈을 제대로 반환 하는지 확인하는 테스트")
	@Test
	void test_rank() {
		Rank rank = Rank.rank(5);
		assertThat(rank.getAmount()).isEqualTo(1500000);
	}
}
