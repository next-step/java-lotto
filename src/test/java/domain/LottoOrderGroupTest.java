package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoOrderGroupTest {
	@Test
	public void 자동_주문그룹_생성_테스트() {
		int size = 3;

		final LottoOrderGroup orderGroup = new LottoOrderGroup(size);

		assertThat(orderGroup.lottos().size()).isEqualTo(size);
	}

	@Test
	public void 수동_주문그룹_생성_테스트() {
		final LottoOrderGroup orderGroup = new LottoOrderGroup(0);

		List<Lotto> handLottos = new ArrayList<>();
		handLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

		handLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));

		handLottos.add(new Lotto(Arrays.asList(8, 9, 11, 4, 5, 7)));

		orderGroup.addHandLottos(handLottos);

		final List<Lotto> lottos = orderGroup.lottos();

		assertThat(lottos.size()).isEqualTo(3);
	}

	@Test
	public void 수동_주문그룹_혼합_생성_테스트() {
		final LottoOrderGroup orderGroup = new LottoOrderGroup(3);

		List<Lotto> handLottos = new ArrayList<>();
		handLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

		handLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));

		handLottos.add(new Lotto(Arrays.asList(8, 9, 11, 4, 5, 7)));

		orderGroup.addHandLottos(handLottos);

		final List<Lotto> lottos = orderGroup.lottos();

		assertThat(lottos.size()).isEqualTo(6);
	}
}