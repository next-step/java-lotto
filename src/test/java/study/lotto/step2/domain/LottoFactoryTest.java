package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;


class LottoFactoryTest {
    private static final int START_SEQUENCE_NUMBER = 1;
    private static final int END_SEQUENCE_NUMBER = 6;

    @Test
    @DisplayName("1에서 6을 선택한 Lotto 객체 생성")
    void create_lotto() {
        // given
        LottoFactory lottoFactory = new LottoFactory(sequenceLottoNumbersFactory());

        // when
        Lotto lotto = lottoFactory.create();

        // then
        assertThat(lotto).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));
    }

    private LottoNumbersFactory sequenceLottoNumbersFactory() {
        return () -> new LottoNumbers(sequenceLottoNumbers());
    }

    private Set<LottoNumber> sequenceLottoNumbers() {
        return IntStream.rangeClosed(START_SEQUENCE_NUMBER, END_SEQUENCE_NUMBER)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toUnmodifiableSet());
    }
}