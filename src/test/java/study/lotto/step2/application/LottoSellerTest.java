package study.lotto.step2.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import study.lotto.step2.domain.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class LottoSellerTest {
    private static final int START_SEQUENCE_NUMBER = 1;
    private static final int END_SEQUENCE_NUMBER = 6;

    @ParameterizedTest(name = "[{index}/4] {displayName}")
    @NullAndEmptySource
    @CsvSource(value = {"-1000", "one thousand won"})
    @DisplayName("문자열 타입의 구입 금액이 양의 정수가 아닐 경우, IllegalArgumentException 예외 발생")
    void invalid_String_format_sell_amount(String invalidAmount) {
        // given
        LottoSeller lottoSeller = new LottoSeller(sequenceLottoFactory());

        // when, then
        assertThatThrownBy(() -> lottoSeller.sell(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 양의 정수로 입력해야 합니다: " + invalidAmount);
    }

    @Test
    @DisplayName("로또 장당 금액(1,000)보다 작은 금액으로 판매 시, IllegalArgumentException 예외 발생")
    void invalid_sell_amount() {
        // given
        long invalidAmount = 999;
        LottoSeller lottoSeller = new LottoSeller(sequenceLottoFactory());

        // when, then
        assertThatThrownBy(() -> lottoSeller.sell(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 구입 금액은 1000원입니다: " + invalidAmount);
    }

    @Test
    @DisplayName("long 타입 입력으로 로또 판매. Lottos 객체 반환")
    void long_type_sell_lottos() {
        // given
        long amount = 4_999;
        LottoSeller lottoSeller = new LottoSeller(sequenceLottoFactory());

        // when
        Lottos lottos = lottoSeller.sell(amount);

        // then
        assertThat(lottos)
                .isEqualTo(new Lottos(List.of(sequenceLotto(), sequenceLotto(), sequenceLotto(), sequenceLotto())));
    }

    @Test
    @DisplayName("String 타입 입력으로 로또 판매. lottos 객체 반환")
    void String_type_sell_lottos() {
        // given
        String amount = "4999";
        LottoSeller lottoSeller = new LottoSeller(sequenceLottoFactory());

        // when
        Lottos lottos = lottoSeller.sell(amount);

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