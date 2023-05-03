package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {
    @Test
    @DisplayName("로또 번호가 6개가 아닐 경우, IllegalArgumentException 예외 발생")
    void invalid_lotto_number_size_the_throw_IllegalArgumentException() {
        // given
        Set<LottoNumber> illegalSizeLottoNumbers = sequenceLottoNumberSet(1, 7);

        // when, then
        assertThatThrownBy(() -> new LottoNumbers(illegalSizeLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호 선택 갯수는 6개입니다: " + illegalSizeLottoNumbers.size());
    }

    @Test
    @DisplayName("로또 번호 Set 반환")
    void numbers() {
        // given
        int startNumber = 1;
        int endNumber = 6;
        LottoNumbers lottoNumbers = new LottoNumbers(sequenceLottoNumberSet(startNumber, endNumber));

        // when, then
        assertThat(lottoNumbers.numbers()).isEqualTo(unmodifiableSequenceIntegerSet(startNumber, endNumber));
    }

    private Set<Integer> unmodifiableSequenceIntegerSet(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .boxed()
                .collect(Collectors.toUnmodifiableSet());
    }

    private Set<LottoNumber> sequenceLottoNumberSet(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .boxed()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }
}