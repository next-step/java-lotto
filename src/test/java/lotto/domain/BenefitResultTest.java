package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BenefitResultTest {

	@DisplayName("총 수익을 계산한다.")
	@Test
	void test1() {
		List<RankSituation> rankSituations = List.of(
			new RankSituation(Rank.FIRST, 2),
			new RankSituation(Rank.FIFTH, 1)
		);

		BenefitResult benefitResult = new BenefitResult(rankSituations, 14000);
		assertThat(benefitResult.getTotalProfit()).isEqualTo(4_000_005_000L);
	}

	@DisplayName("총 수익률을 계산한다.")
	@Test
	void test2() {
		BenefitResult benefitResult = new BenefitResult(14_000, 5_000);
		assertThat(benefitResult.totalProfitRate()).isEqualTo(0.35);
	}

	@DisplayName("손익 여부를 계산한다. - 이득인 케이스")
	@Test
	void test3() {
		BenefitResult benefitResult = new BenefitResult(1.01);
		assertThat(benefitResult.isBenefit()).isTrue();
	}

	@DisplayName("손익 여부를 계산한다. - 손해인 케이스")
	@Test
	void test4() {
		BenefitResult benefitResult = new BenefitResult(0.99);
		assertThat(benefitResult.isBenefit()).isFalse();
	}
}
