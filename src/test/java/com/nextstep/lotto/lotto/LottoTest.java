package com.nextstep.lotto.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoTest {

	Set<LottoNumber> winningNumbers = new HashSet<>();
	Lotto winningLotto;

	@BeforeEach
	void setUp() {
		winningNumbers.add(new LottoNumber(1));
		winningNumbers.add(new LottoNumber(2));
		winningNumbers.add(new LottoNumber(3));
		winningNumbers.add(new LottoNumber(4));
		winningNumbers.add(new LottoNumber(5));
		winningNumbers.add(new LottoNumber(6));

		winningLotto = new Lotto(winningNumbers);
	}

	@Test
	void create() {
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		lottoNumbers.add(new LottoNumber(1));
		lottoNumbers.add(new LottoNumber(2));
		lottoNumbers.add(new LottoNumber(3));
		lottoNumbers.add(new LottoNumber(4));
		lottoNumbers.add(new LottoNumber(5));
		lottoNumbers.add(new LottoNumber(6));

		Lotto lotto = new Lotto(lottoNumbers);
		assertThat(lotto).isNotNull();
	}

	@Test
	void 숫자개수가_6개가_아니면_exception() {
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		lottoNumbers.add(new LottoNumber(1));
		lottoNumbers.add(new LottoNumber(2));
		lottoNumbers.add(new LottoNumber(3));
		lottoNumbers.add(new LottoNumber(4));
		lottoNumbers.add(new LottoNumber(5));

		assertThatThrownBy(() ->
			new Lotto(lottoNumbers)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 중복된_숫자가_들어오면_exception() {
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		lottoNumbers.add(new LottoNumber(1));
		lottoNumbers.add(new LottoNumber(2));
		lottoNumbers.add(new LottoNumber(3));
		lottoNumbers.add(new LottoNumber(4));
		lottoNumbers.add(new LottoNumber(5));
		lottoNumbers.add(new LottoNumber(5));

		assertThatThrownBy(() ->
			new Lotto(lottoNumbers)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 매칭되는_숫자_개수_6개() {
		Lotto lotto = new Lotto(winningNumbers);
		assertThat(lotto.match(winningLotto)).isEqualTo(6);
	}

	@Test
	void 매칭되는_숫자_개수_5개() {
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		lottoNumbers.add(new LottoNumber(1));
		lottoNumbers.add(new LottoNumber(2));
		lottoNumbers.add(new LottoNumber(3));
		lottoNumbers.add(new LottoNumber(4));
		lottoNumbers.add(new LottoNumber(5));
		lottoNumbers.add(new LottoNumber(7));

		Lotto lotto = new Lotto(lottoNumbers);
		assertThat(lotto.match(winningLotto)).isEqualTo(5);
	}

	@Test
	void 매칭되는_숫자_개수_4개() {
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		lottoNumbers.add(new LottoNumber(1));
		lottoNumbers.add(new LottoNumber(2));
		lottoNumbers.add(new LottoNumber(3));
		lottoNumbers.add(new LottoNumber(4));
		lottoNumbers.add(new LottoNumber(7));
		lottoNumbers.add(new LottoNumber(8));

		Lotto lotto = new Lotto(lottoNumbers);
		assertThat(lotto.match(winningLotto)).isEqualTo(4);
	}

	@Test
	void 매칭되는_숫자_개수_3개() {
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		lottoNumbers.add(new LottoNumber(1));
		lottoNumbers.add(new LottoNumber(2));
		lottoNumbers.add(new LottoNumber(3));
		lottoNumbers.add(new LottoNumber(7));
		lottoNumbers.add(new LottoNumber(8));
		lottoNumbers.add(new LottoNumber(9));

		Lotto lotto = new Lotto(lottoNumbers);
		assertThat(lotto.match(winningLotto)).isEqualTo(3);
	}
}
