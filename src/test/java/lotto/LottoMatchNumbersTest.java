package lotto;

import lotto.domain.LottoMatchNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoMatchNumbersTest {

    @DisplayName("LottoMatchNumbers 객체를 생성하면 맞은 갯수들의 정보가 0으로 설정된다.")
    @Test
    void LottoMatchNumbersCreateTest() {
        LottoMatchNumbers lottoMatchNumbers = new LottoMatchNumbers();
        Map<Integer, Integer> matchNumberMap = lottoMatchNumbers.getMatchNumberMap();

        assertThat(matchNumberMap.get(3)).isEqualTo(0);
        assertThat(matchNumberMap.get(4)).isEqualTo(0);
        assertThat(matchNumberMap.get(5)).isEqualTo(0);
        assertThat(matchNumberMap.get(6)).isEqualTo(0);
    }

    @DisplayName("음수 또는 6을 넘는 숫자를 넘기면 IllegalArgumentException을 던진다")
    @Test
    void putErrorTest() {
        LottoMatchNumbers lottoMatchNumbers = new LottoMatchNumbers();

        assertThatThrownBy(() -> lottoMatchNumbers.put(-1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lottoMatchNumbers.put(8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3보다 작은 숫자를 전달하면 아무것도 변하지 않는다.")
    @Test
    void putMinValueTest() {
        LottoMatchNumbers lottoMatchNumbers = new LottoMatchNumbers();
        lottoMatchNumbers.put(2);
        lottoMatchNumbers.put(0);
        Map<Integer, Integer> matchNumberMap = lottoMatchNumbers.getMatchNumberMap();

        assertThat(matchNumberMap.get(3)).isEqualTo(0);
        assertThat(matchNumberMap.get(4)).isEqualTo(0);
        assertThat(matchNumberMap.get(5)).isEqualTo(0);
        assertThat(matchNumberMap.get(6)).isEqualTo(0);
    }

    @DisplayName("3-6 사이의 값을 전달하면 해당 값을 키로 가진 데이터가 1 추가된다.")
    @Test
    void putSuccessTest() {
        LottoMatchNumbers lottoMatchNumbers = new LottoMatchNumbers();
        lottoMatchNumbers.put(5);
        lottoMatchNumbers.put(4);

        Map<Integer, Integer> matchNumberMap = lottoMatchNumbers.getMatchNumberMap();

        assertThat(matchNumberMap.get(3)).isEqualTo(0);
        assertThat(matchNumberMap.get(4)).isEqualTo(1);
        assertThat(matchNumberMap.get(5)).isEqualTo(1);
        assertThat(matchNumberMap.get(6)).isEqualTo(0);
    }
}
