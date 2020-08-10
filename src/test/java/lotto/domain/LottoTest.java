package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("당첨번호 콤마가 아닌 다른 구분자로 입력")
    void fromNumber_invalidDelimiter_exceptThrown() {
        assertThatThrownBy(() -> Lotto.fromString("1:2:3")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호 6개 입력하지 않을 경우")
    void fromNumber_insertNotSix_exceptThrown() {
        assertThatThrownBy(() -> Lotto.fromString("10,20,30")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호 6개 입력")
    void fromNumber_insertSix_returnLottoNumber() {
        int[] lottoArray = Lotto.fromString("16,22,33,41,44,45").toArray();
        Arrays.sort(lottoArray);
        assertThat(lottoArray).isEqualTo(new int[] {16,22,33,41,44,45});
    }

    @Test
    @DisplayName("당첨번호 매칭 개수 확인")
    void getMatchCount() {
        Lotto lotto1 = Lotto.fromString("16,22,33,41,44,45");
        Lotto lotto2 = Lotto.fromString("16,22,33,40,44,45");
        assertThat(lotto1.countOfMatch(lotto2)).isEqualTo(5);
    }
}
