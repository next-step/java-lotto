package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumTest {
    LottoNum bonus = new LottoNum(45);
    LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 45));

    @DisplayName("1~45 범위 내 검사")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 40, 45})
    void checkRangeTest(int num) {
        assertThat(new LottoNum(num).getLottoNum()).isBetween(1, 45);
    }

    @DisplayName("1~45 범위 외 검사")
    @Test
    void checkOutOfRangeTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNum(46).getLottoNum();
        });
    }

    @DisplayName("보너스 볼 생성")
    @Test
    void makeBounsNumberTest() {
        assertThat(bonus.getLottoNum()).isBetween(1, 45);
    }

    @DisplayName("보너스볼 일치")
    @Test
    void matchBonusNumberTest() {
        assertThat(bonus.matchNumber(lottoTicket)).isTrue();
    }

    @DisplayName("보너스번호가 이미 생성된 당첨 번호랑 겹치는지 검사")
    @Test
    void checkOverlapTest() {
        String winnginglotto = "1,2,3,4,5,45";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNum(45, winnginglotto);
        });
    }

    @DisplayName("숫자 변환 불가")
    @Test
    public void isNumberTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNum("a");
        });
    }
}
