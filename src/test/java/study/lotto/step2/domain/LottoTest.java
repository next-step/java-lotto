package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @Test
    @DisplayName("로또 번호가 6개가 아닐 경우, IllegalArgumentException 예외 발생")
    void invalid_lotto_number_size_the_throw_IllegalArgumentException() {
        // given
        Set<LottoNumber> illegalSizeLottoNumbers = sequenceLottoNumberSet(1, 7);

        // when, then
        assertThatThrownBy(() -> new Lotto(illegalSizeLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호 선택 갯수는 6개입니다: " + illegalSizeLottoNumbers.size());
    }

    @Test
    @DisplayName("선택한 로또 번호 오름차순 정렬 후 반환")
    void numbers() {
        // given
        Lotto lotto = new Lotto(sequenceLottoNumberSet(1, 6));

        // when
        Set<Integer> lottoNumbers = lotto.numbers();

        // then
        Set<Integer> expectedLottoNumbers = Collections.unmodifiableSortedSet(new TreeSet<>(Set.of(1, 2, 3, 4, 5, 6)));
        assertThat(lottoNumbers).isEqualTo(expectedLottoNumbers);
    }

    private Set<LottoNumber> sequenceLottoNumberSet(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}