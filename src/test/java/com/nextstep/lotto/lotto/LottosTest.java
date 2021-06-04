package com.nextstep.lotto.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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

		List<Lotto> lottoList = new ArrayList<>();
		lottoList.add(new Lotto(new LottoNumberGenerator() {
			@Override
			public List<LottoNumber> makeRandomNumbers() {
				List<LottoNumber> list = new ArrayList<>();
				list.add(new LottoNumber(1));
				list.add(new LottoNumber(2));
				list.add(new LottoNumber(3));
				list.add(new LottoNumber(4));
				list.add(new LottoNumber(5));
				list.add(new LottoNumber(6));
				return list;
			}
		}));
		lottoList.add(new Lotto(new LottoNumberGenerator() {
			@Override
			public List<LottoNumber> makeRandomNumbers() {
				List<LottoNumber> list = new ArrayList<>();
				list.add(new LottoNumber(1));
				list.add(new LottoNumber(2));
				list.add(new LottoNumber(3));
				list.add(new LottoNumber(4));
				list.add(new LottoNumber(5));
				list.add(new LottoNumber(6));
				return list;
			}
		}));
		lottoList.add(new Lotto(new LottoNumberGenerator() {
			@Override
			public List<LottoNumber> makeRandomNumbers() {
				List<LottoNumber> list = new ArrayList<>();
				list.add(new LottoNumber(1));
				list.add(new LottoNumber(2));
				list.add(new LottoNumber(3));
				list.add(new LottoNumber(4));
				list.add(new LottoNumber(5));
				list.add(new LottoNumber(6));
				return list;
			}
		}));

		List<LottoNumber> list = new ArrayList<>();
		list.add(new LottoNumber(1));
		list.add(new LottoNumber(2));
		list.add(new LottoNumber(3));
		list.add(new LottoNumber(4));
		list.add(new LottoNumber(5));
		list.add(new LottoNumber(6));
		Lottos lottos = new Lottos(lottoList);
		WinningLotto winningLotto = new WinningLotto(list);
		assertThat(lottos.matchRank(winningLotto).size()).isEqualTo(3);
	}
}
