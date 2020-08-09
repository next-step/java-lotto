package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @DisplayName("입력된 번호로 로또가 잘 생성되는지 확인")
    @Test
    public void lottoNewTest() {
        // given
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        List<LottoNumber> lottoNumbers = lotto.getNumbers();

        // when & then
        assertAll(
                () -> assertThat(lotto.getNumbers()).hasSize(6),
                () -> assertThat(lottoNumbers.stream().anyMatch(n -> n.equals(new LottoNumber(1)))).isTrue(),
                () -> assertThat(lottoNumbers.stream().anyMatch(n -> n.equals(new LottoNumber(7)))).isFalse()
        );
    }

    @DisplayName("입력된 번호가 중복일 경우 예외 발생")
    @Test
    public void lottoNewDuplicateThrownTest() {
        // when & then
        assertThatThrownBy(() -> new Lotto("1,1,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 번호가 있습니다");
    }

    @DisplayName("입력된 번호가 6개가 아닐 경우 예외 발생")
    @Test
    public void lottoNewNotValidSizeThrownTest() {
        // when & then
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호 개수가 6개가 아닙니다");

    }

    @DisplayName("입력된 번호가 있을 경우 결과를 잘 반환하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "1:true",
            "2:true",
            "3:true",
            "4:true",
            "7:false"
    }, delimiter = ':')
    public void containTest(int number, boolean expected) {
        // given
        Lotto lotto = new Lotto("1,2,3,4,5,6");

        // when
        assertThat(lotto.contain(new LottoNumber(number)))
                .isEqualTo(expected);
    }

    @DisplayName("입력된 로또번호와 맞는 번호 개수가 잘 반환 되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:6",
            "1,2,3,4,5,16:5",
            "1,2,3,4,15,16:4",
            "1,2,3,14,15,16:3",
            "11,12,13,14,15,16:0"
    }, delimiter = ':')
    public void containTest(String input, int expected) {
        // given
        Lotto lotto = new Lotto("1,2,3,4,5,6");

        // when
        assertThat(lotto.getMatchCount(new Lotto(input)))
                .isEqualTo(expected);
    }
}
