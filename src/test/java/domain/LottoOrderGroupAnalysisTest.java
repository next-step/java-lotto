package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoOrderGroupAnalysisTest {
	@Test
	public void 로또_숫자_맞춤_계산() {
		//???
	}

	@Test
	public void 수익률_계산() {
		LottoOrderGroupAnalysis analysis = new LottoOrderGroupAnalysis(
				new Integer[]{1, 2, 3, 4, 5, 6}
				, new LottoOrderGroup(10)
		);
		//??
		analysis.yield();
	}
}