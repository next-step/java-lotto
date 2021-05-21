package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {

    @Test
    @DisplayName("로또번호 생성")
    void create() {
        // given
        List<LottoNumber> lottoNumberList = Stream.of(8, 21, 23, 41, 42, 43).map(LottoNumber::of).collect(Collectors.toList());

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
        List<LottoNumber> lottoNumberMoreCount = Stream.of(8, 21, 23, 41, 42, 43, 33).map(LottoNumber::of).collect(Collectors.toList());
        List<LottoNumber> lottoNumberLessCount = Stream.of(8, 21, 23, 41, 42).map(LottoNumber::of).collect(Collectors.toList());

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
        List<LottoNumber> lottoNumberList = Stream.of(8, 21, 23, 41, 43, 43).map(LottoNumber::of).collect(Collectors.toList());

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(lottoNumberList))
                .withMessageMatching("중복된 번호가 존재합니다.");
    }
}