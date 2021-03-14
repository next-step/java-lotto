package camp.nextcamp.edu.lotto.entity;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchasedLottoTest {

	@Test
	@DisplayName("총 개수 테스트")
	void all_count() {

		// given
		List<String> inputs = Stream.of(
			"1, 2, 3, 4, 5, 6",
			"1, 2, 3, 4, 5, 7",
			"1, 2, 3, 4, 5, 8"
		)
			.collect(Collectors.toList());

		// when
		PurchasedLotto lotto = new PurchasedLotto(new ManualLottoTicket(inputs, 13), new LottoTicket(10));

		// then
		assertThat(lotto.getAutomaticLottoCount() +
			lotto.getManualLottoCount())
			.isEqualTo(13);
	}
}
