package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto.LottoNumber;
import step2.exception.ListNullPointerException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputLottoNumbersTest {

    private List<LottoNumber> testLottoNumbers;

    @BeforeEach
    void setUp() {
        testLottoNumbers = IntStream
                .range(1, 6)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    @DisplayName("InputLottoNumbers 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        InputLottoNumbers inputLottoNumbers = InputLottoNumbers.newInstance(testLottoNumbers);

        // then
        assertThat(inputLottoNumbers).isNotNull();
    }

    @DisplayName("InputLottoNumbers 인스턴스에 null 주입시 예외처리 발생 여부 테스트")
    @Test
    void 검증_Null() {
        // given
        List<LottoNumber> nullLottoNumbers = null;

        // when and then
        assertThatThrownBy(()-> {
            InputLottoNumbers.newInstance(testLottoNumbers);
        }).isInstanceOf(ListNullPointerException.class)
                .hasMessageContaining("null인 리스트가 입력되었습니다.");

    }


}