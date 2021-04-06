package step4.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.exception.LottoSizeMissMatchException;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    private Set<LottoNumber> lottoNumbers;

    @BeforeEach
    void beforeEach() {
        lottoNumbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toCollection(TreeSet::new));
    }


    @DisplayName("Lotto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        Lotto lotto = Lotto.of(lottoNumbers);

        // then
        assertThat(lotto).isNotNull();
    }

    @DisplayName("Lotto 인스턴스에 알맞지 않은 갯수 입력시 예외처리 여부 테스트")
    @Test
    void 검증_사이즈() {

        // when and then
        assertThatThrownBy(() -> Lotto.of(lottoNumbers))
                .isInstanceOf(LottoSizeMissMatchException.class)
                .hasMessageContaining("로또 숫자가 맞지 않습니다.");

    }

}