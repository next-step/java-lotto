package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RevenueRecordTest {

	@Test
	@DisplayName("로또 5개 중 5개 모두 당첨")
	void winLottoRevenue() {
		List<Lotto> lottos = new ArrayList<>(5);

		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));

		Lotto winLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

		RevenueRecord revenueRecord = new RevenueRecord(lottos);

		revenueRecord.aggregate(winLotto);
	}
}