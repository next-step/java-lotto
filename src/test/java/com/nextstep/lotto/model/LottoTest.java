package com.nextstep.lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

	@DisplayName("로또를 생성하면 로또번호가 생성되어 저장되는지 테스트")
	@Test
	void 로또를_생성하면_로또번호가_생성되어_저장되는지_테스트() {
		Lotto lotto = new Lotto();
		assertThat(lotto.getLottoNumbers().isEmpty()).isFalse();
	}

	@DisplayName("로또가 6개의 로또 번호를 가지는지 테스트")
	@Test
	void 로또가_6개의_로또넘버를_가지는지_테스트() {
		Lotto lotto = new Lotto();
		assertThat(lotto.size()).isEqualTo(6);
	}
}
