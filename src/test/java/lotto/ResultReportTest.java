package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultReportTest {

	@Test
	void verifyReward() {

		ResultReport report = new ResultReport();
		report.increment(LottoResult.WIN_1ST);

		int totalReward = report.totalReward();

		assertThat(totalReward).isEqualTo(LottoResult.WIN_1ST.getReward());
	}
}