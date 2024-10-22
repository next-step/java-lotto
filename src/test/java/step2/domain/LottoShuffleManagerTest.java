package step2.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step2.domain.LottoShuffleManager.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoShuffleManagerTest {
	@Test
	@DisplayName("로또 당첨 번호가 오름차순으로 정렬하는지 체크하는 테스트")
	public void checkLottoSortTest() {
		List<LottoNumber> lottos = shuffleSixNumbers();
		List<LottoNumber> sortedLottos = new ArrayList<>(lottos);
		Collections.sort(sortedLottos);
		assertThat(lottos).isEqualTo(sortedLottos);
	}
}
