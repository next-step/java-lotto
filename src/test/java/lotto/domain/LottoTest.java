package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
	@DisplayName("로또를 생성한다.")
	@Test
	void 로또를_생성한다() {
		Stream<Lotto> allLottoNumber = Arrays.stream(Lotto.values());
		List<Lotto> allLottoNumberList = allLottoNumber.collect(Collectors.toList());
		List<Lotto> lottos = new ArrayList<>(6);
		Collections.shuffle(allLottoNumberList);
		for (int i = 0; i < 6; i++) {
			lottos.add(allLottoNumberList.get(i));
		}
		assertThat(lottos.get(0).isBetween(new Digit(1), new Digit(45))).isTrue();
	}
}
