package step2.domain.Lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.ListNullPointerException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    void setUp(){
        lottoNumbers =  IntStream.range(1, 6)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    @DisplayName("Lotto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        Lotto lotto = Lotto.newInstance(lottoNumbers);

        // then
        assertThat(lotto).isNotNull();
    }

    @DisplayName("Lotto 인스턴스 null 주입시 예외처리 테스트")
    @Test
    void 검증_Null() {

        // given
        List<LottoNumber> nullLottoNumbers = null;

        // when and then
        assertThatThrownBy(()-> {
                    Lotto.newInstance(nullLottoNumbers);
        }).isInstanceOf(ListNullPointerException.class)
                .hasMessageContaining("null인 리스트가 입력되었습니다.");

    }

    @DisplayName("Lotto 인스턴스가 소유한 값 반환 여부 테스트")
    @Test
    void 반환() {

        // given
        Lotto lotto = Lotto.newInstance(lottoNumbers);

        // when
        List<LottoNumber> actual = lotto.getLottoNumbers();

        // then
        assertThat(actual).isEqualTo(lottoNumbers);
    }
}