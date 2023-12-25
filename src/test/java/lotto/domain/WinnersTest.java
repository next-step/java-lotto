package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.controller.LottoGenerator;

public class WinnersTest {
	@DisplayName("당첨 번호와 일치 여부 확인.")
	@Test
	void 일치_여부_확인() {
		Set<Lotto> lottoSet = Set.of(Lotto.ONE, Lotto.TWO, Lotto.THREE, Lotto.FOUR, Lotto.FIVE, Lotto.SIX);
		Winners winners = new Winners(Winners.winningNumbers(lottoSet));
		List<Lotto> lottos = LottoGenerator.generate(1).get(0).lottos();

		int count = winners.countWinningNumbers(lottos);

		assertThat(count).isBetween(0, 6);
	}
}
