package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoTest {

    @Test
    @DisplayName("getMatchingNumberCount 메서드에 null을 전달하면 0이 반환된다.")
    void getMatchingNumberCountParameterIsNullTest() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getMatchingNumberCount(null)).isZero();
    }

    @Test
    @DisplayName("getMatchingNumberCount 메서드가 일치하는 로또번호 개수를 반환한다.")
    void getMatchingNumberCountTest() {
        Lotto lotto1 = new Lotto(Set.of(LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5),
                LottoNumber.valueOf(6)));
        Lotto lotto2 = new Lotto(Set.of(LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(14),
                LottoNumber.valueOf(15),
                LottoNumber.valueOf(16)));
        assertThat(lotto1.getMatchingNumberCount(lotto2)).isEqualTo(3);
    }

    @Test
    @DisplayName("Lotto 객체를 생성할 때 로또 번호가 6개가 아니면 예외가 발생한다.")
    void initDuplicateNumberTest() {
        Set<LottoNumber> lottoNumbers = Set.of(LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5));
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호의 개수가 일치하지 않습니다.");
    }
}