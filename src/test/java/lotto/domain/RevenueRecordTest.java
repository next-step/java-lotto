package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.enums.Rank;

class RevenueRecordTest {

	@Test
	@DisplayName("로또 5개 중 5개 모두 당첨")
	void winLottoRevenue() {
		List<Lotto> lottos = new ArrayList<>(5);

		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

		Lotto winLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

		RevenueRecord revenueRecord = new RevenueRecord(lottos);

		Map<Rank, Integer> records = revenueRecord.aggregate(winLotto)
									.getRecords();

		assertThat(records.get(Rank.FIRST)).isEqualTo(5);
	}

	@Test
	@DisplayName("로또 5개 중 5개 모두 당첨 금액")
	void sumRevenue() {
		List<Lotto> lottos = new ArrayList<>(5);

		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

		Lotto winLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

		RevenueRecord revenueRecord = new RevenueRecord(lottos);

		Records records = revenueRecord.aggregate(winLotto);

		assertThat(records.sumRevenue()).isEqualTo(10000000000L);
	}
}