package step2.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;
import static step2.domain.LottoShuffleManager.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoShuffleManagerTest {
	@Test
	@DisplayName("로또 당첨 번호가 오름차순으로 정렬하는지 체크하는 테스트")
	public void checkLottoSortTest() {
		List<LottoNumber> lottoNumbers = shuffleSixNumbers();
		List<LottoNumber> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
		Collections.sort(sortedLottoNumbers);
		assertThat(lottoNumbers).isEqualTo(sortedLottoNumbers);
	}

	@Test
	@DisplayName("로또 당첨 번호가 잘 섞이는지 체크하는 테스트")
	public void checkLottoShuffleTest() {
		Set<Lotto> lottoSets = new HashSet<>();
		for (int i = 0; i < 100; i++) {
			Lotto lotto = new Lotto(LottoShuffleManager.shuffleSixNumbers());
			lottoSets.add(lotto);
		}
		assertTrue(lottoSets.size() > 95); // 매우 희박한 확률
	}
}
