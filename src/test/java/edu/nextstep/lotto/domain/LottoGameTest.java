package edu.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottoGame: 판매된 로또번호들, 당첨번호, 보너스 숫자를 필드로 가지는 로또 게임 클래스")
public class LottoGameTest {

	@DisplayName("createOf: LottoGame 객체를 정상적으로 생성하여 리턴함")
	@Test
	void createOf() {
		List<List<Integer>> purchasedLottoNumbersList = Collections.emptyList();
		List<Integer> winningLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		int bonusNumber = 7;
		assertThat(LottoGame.createOf(purchasedLottoNumbersList, winningLottoNumbers, bonusNumber))
			.isNotNull()
			.isInstanceOf(LottoGame.class);
	}

	@DisplayName("createOf: 보너스 볼에 문제가 있어 LottoGame 객체를 정상적으로 생성하지 못하고 예외 발생")
	@ParameterizedTest
	@ValueSource(ints = {-1, 6, 46})
	void createOf_shouldException(int bonusNumber) {
		List<List<Integer>> purchasedLottoNumbersList = Collections.emptyList();
		List<Integer> winningLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		assertThatThrownBy(() -> LottoGame.createOf(purchasedLottoNumbersList, winningLottoNumbers, bonusNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}
}