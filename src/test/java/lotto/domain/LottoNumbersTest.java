package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {

    @Test
    @DisplayName("로또번호 생성")
    void create() {
        // given
        Set<LottoNumber> lottoNumberList = Stream.of(8, 21, 23, 41, 42, 43).map(LottoNumber::of).collect(Collectors.toSet());

        // when
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);

        // then
        for (LottoNumber lottoNumber : lottoNumbers) {
            assertThat(lottoNumber.number()).isBetween(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER);
        }
    }

    @Test
    @DisplayName("로또번호 생성 - null")
    void crate_nullParam() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(null))
                .withMessageMatching("로또번호를 입력해 주세요.");
    }

    @Test
    @DisplayName("로또번호 생성 - 유효하지 않은 갯수")
    void crate_invalidNumberCount() {
        // given
        Set<LottoNumber> lottoNumberMoreCount = Stream.of(8, 21, 23, 41, 42, 43, 33).map(LottoNumber::of).collect(Collectors.toSet());
        Set<LottoNumber> lottoNumberLessCount = Stream.of(8, 21, 23, 41, 42).map(LottoNumber::of).collect(Collectors.toSet());

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(lottoNumberMoreCount))
                .withMessageMatching("로또번호는 6 개의 숫자로 이루어져야 합니다.");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(lottoNumberLessCount))
                .withMessageMatching("로또번호는 6 개의 숫자로 이루어져야 합니다.");
    }

    @Test
    @DisplayName("로또번호 생성 - 중복된 숫자")
    void create_duplicateNumber() {
        // given
        Set<LottoNumber> lottoNumberList = Stream.of(8, 21, 23, 41, 43, 43).map(LottoNumber::of).collect(Collectors.toSet());

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(lottoNumberList))
                .withMessageMatching("로또번호는 6 개의 숫자로 이루어져야 합니다.");
    }

    @Test
    @DisplayName("숫자 매칭 - 전체 일치")
    void matchCount() {
        // given
        Set<LottoNumber> lottoNumberList = Stream.of(8, 21, 23, 41, 43, 42).map(LottoNumber::of).collect(Collectors.toSet());
        Set<LottoNumber> targetNumberList = Stream.of(21, 8, 41, 23, 42, 43).map(LottoNumber::of).collect(Collectors.toSet());

        // when
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);
        LottoNumbers targetNumbers = new LottoNumbers(targetNumberList);

        // then
        assertThat(lottoNumbers.matchCount(targetNumbers)).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 매칭 - 일부 일치")
    void matchCount_someOf() {
        // given
        Set<LottoNumber> lottoNumberList = Stream.of(8, 21, 23, 41, 43, 42).map(LottoNumber::of).collect(Collectors.toSet());
        Set<LottoNumber> targetNumberList = Stream.of(21, 8, 22, 15, 42, 43).map(LottoNumber::of).collect(Collectors.toSet());

        // when
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);
        LottoNumbers targetNumbers = new LottoNumbers(targetNumberList);

        // then
        assertThat(lottoNumbers.matchCount(targetNumbers)).isEqualTo(4);
    }

    @Test
    @DisplayName("숫자 매칭 - 전체 불일치")
    void matchCount_notMatch() {
        // given
        Set<LottoNumber> lottoNumberList = Stream.of(8, 21, 23, 41, 43, 42).map(LottoNumber::of).collect(Collectors.toSet());
        Set<LottoNumber> targetNumberList = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toSet());

        // when
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);
        LottoNumbers targetNumbers = new LottoNumbers(targetNumberList);

        // then
        assertThat(lottoNumbers.matchCount(targetNumbers)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 포함 테스트")
    void contains() {
        // given
        Set<LottoNumber> lottoNumberList = Stream.of(8, 21, 23, 41, 43, 42).map(LottoNumber::of).collect(Collectors.toSet());

        // when
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);

        // then
        assertThat(lottoNumbers.contains(LottoNumber.of(8))).isTrue();
        assertThat(lottoNumbers.contains(LottoNumber.of(21))).isTrue();
        assertThat(lottoNumbers.contains(LottoNumber.of(23))).isTrue();
        assertThat(lottoNumbers.contains(LottoNumber.of(41))).isTrue();
        assertThat(lottoNumbers.contains(LottoNumber.of(43))).isTrue();
        assertThat(lottoNumbers.contains(LottoNumber.of(42))).isTrue();
        assertThat(lottoNumbers.contains(LottoNumber.of(33))).isFalse();
    }
}