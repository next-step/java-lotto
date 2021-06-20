package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoOrderGroupTest {
	@Test
	public void 주문그룹_생성_테스트 () {
		int size = 3;

		final LottoOrderGroup orderGroup = new LottoOrderGroup(size);

		assertThat(orderGroup.lottos().size()).isEqualTo(size);
	}
}