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

class LottoNumbersTest {

    private List<LottoNumber> lottoNumberList;

    @BeforeEach
    void setUp(){
        lottoNumberList =  IntStream.range(1, 7)
                    .mapToObj(LottoNumber::valueOf)
                    .collect(Collectors.toList());
    }

    @DisplayName("LottoNumbers 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        LottoNumbers lottoNumbers = LottoNumbers.newInstance(lottoNumberList);

        // then
        assertThat(lottoNumbers).isNotNull();
    }

    @DisplayName("LottoNumbers 인스턴스 부적절한 값 입력시 예외처리 발생 여부 테스트")
    @Test
    void 검증_Null() {
        // given
        List<LottoNumber> nullLottoNumberList = null;

        // when and then
        assertThatThrownBy(()-> {
            LottoNumbers.newInstance(nullLottoNumberList);
        }).isInstanceOf(ListNullPointerException.class)
                .hasMessageContaining("null인 리스트가 입력되었습니다.");

    }

    @DisplayName("LottoNumbers 인스턴스가 소유한 값을 기준으로 비교하는지 테스트")
    @Test
    void 비교() {

        // when
        LottoNumbers firstLottoNumbers = LottoNumbers.newInstance(lottoNumberList);
        LottoNumbers secondLottoNumbers = LottoNumbers.newInstance(lottoNumberList);

        // then
        assertThat(firstLottoNumbers).isEqualTo(secondLottoNumbers);
    }

}