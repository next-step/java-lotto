package study.lotto.step2.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.step2.domain.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class LottoSellerTest {
    private static final int START_SEQUENCE_NUMBER = 1;
    private static final int END_SEQUENCE_NUMBER = 6;

    @Test
    @DisplayName("Lottos 객체 판매(생성)")
    void sell_lottos() {
        // given
        LottoPurchase lottoPurchase = new LottoPurchase(4_999);
        LottoSeller lottoSeller = new LottoSeller(sequenceLottoFactory());

        // when
        Lottos lottos = lottoSeller.sell(lottoPurchase);

        // then
        assertThat(lottos)
                .isEqualTo(new Lottos(List.of(sequenceLotto(), sequenceLotto(), sequenceLotto(), sequenceLotto())));
    }

    private Lotto sequenceLotto() {
        return new Lotto(sequenceLottoNumbers());
    }

    private LottoFactory sequenceLottoFactory() {
        return new LottoFactory(sequenceLottoNumbersFactory());
    }

    private LottoNumbersFactory sequenceLottoNumbersFactory() {
        return this::sequenceLottoNumbers;
    }

    private LottoNumbers sequenceLottoNumbers() {
        return new LottoNumbers(sequenceLottoNumbers(START_SEQUENCE_NUMBER, END_SEQUENCE_NUMBER));
    }

    private Set<LottoNumber> sequenceLottoNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toUnmodifiableSet());
    }
}