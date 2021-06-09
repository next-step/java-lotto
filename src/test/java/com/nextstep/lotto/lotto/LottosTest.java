package com.nextstep.lotto.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class LottosTest {

	@Test
	void create() {
		List<Lotto> lottoList = new ArrayList<>();
		Lottos lottos = new Lottos(lottoList);
		assertThat(lottos).isNotNull();
	}

	@Test
	void 결과값_도출() {
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		lottoNumbers.add(new LottoNumber(1));
		lottoNumbers.add(new LottoNumber(2));
		lottoNumbers.add(new LottoNumber(3));
		lottoNumbers.add(new LottoNumber(4));
		lottoNumbers.add(new LottoNumber(5));
		lottoNumbers.add(new LottoNumber(6));
		LottoNumber bonusNumber = new LottoNumber(10);

		List<Lotto> lottoList = new ArrayList<>();
		lottoList.add(new Lotto(lottoNumbers, bonusNumber));
		lottoList.add(new Lotto(lottoNumbers, bonusNumber));
		lottoList.add(new Lotto(lottoNumbers, bonusNumber));

		Lottos lottos = new Lottos(lottoList);

		Set<LottoNumber> winningNumbers = new HashSet<>();
		winningNumbers.add(new LottoNumber(1));
		winningNumbers.add(new LottoNumber(2));
		winningNumbers.add(new LottoNumber(3));
		winningNumbers.add(new LottoNumber(4));
		winningNumbers.add(new LottoNumber(5));
		winningNumbers.add(new LottoNumber(6));
		WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers, bonusNumber), bonusNumber);

		assertThat(lottos.matchRank(winningLotto).size()).isEqualTo(3);
	}
}
