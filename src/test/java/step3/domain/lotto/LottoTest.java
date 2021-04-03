package step3.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.exception.LottoSizeMissMatchException;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private Set<LottoNumber> lottoNumbers;

    @BeforeEach
    void beforeEach() {
        lottoNumbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toSet());

    }

    @DisplayName("Lotto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        Set<LottoNumber> inputValue = lottoNumbers;

        // when
        Lotto lotto = Lotto.of(inputValue);

        // then
        assertThat(lotto).isNotNull();
    }

    @DisplayName("Lotto 인스턴스 자릿수 검증 여부 테스트")
    @Test
    void 검증_자릿수() {
        // given
        Set<LottoNumber> sizeMissLottoNumbers = IntStream.range(1, 6)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        // when
        assertThatThrownBy(()-> Lotto.of(sizeMissLottoNumbers))
                .isInstanceOf(LottoSizeMissMatchException.class)
                .hasMessageContaining("로또 숫자가 맞지 않습니다.");


    }

}