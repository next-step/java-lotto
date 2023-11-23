package lottosecond.domain;

import lottosecond.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringToLottoConvertorTest {

    @DisplayName("로또 번호 문자열이 , 로 구분되어 있지 않으면 에러가 발생합니다.")
    @Test
    void illegalNumber() {
        // given
        String stringNumber = "1, 2, 3: 4, 5, 6";
        // when
        // then
        assertThatThrownBy(() -> StringToLottoConvertor.lottoConvert(stringNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 로또 번호 입력 형태입니다.");
    }

    @DisplayName("로또 번호 문자열이 ,로 구분된 중복없는 6개의 숫자라면 로또를 생성합니다.")
    @Test
    void makeLotto() {
        // given
        String stringNumber = "1, 2, 3, 4, 5, 6";
        // when
        Lotto lotto = StringToLottoConvertor.lottoConvert(stringNumber);
        // then
        assertThat(lotto).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 번호 문자열이 여러개 들어온다면 해당 개수만큼 로또를 만들어 리스트로 반환합니다.")
    @Test
    void makeLottoList() {
        // given
        List<String> stringNumberList = List.of("1, 2, 3, 4, 5, 6", "11, 12, 13, 14, 15, 16");
        // when
        List<Lotto> lottoList = StringToLottoConvertor.lottoListConvert(stringNumberList);
        // then
        assertThat(lottoList).isEqualTo(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16))
        ));
    }
}