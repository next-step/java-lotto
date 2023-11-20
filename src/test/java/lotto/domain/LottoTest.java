package lotto.domain;

import lotto.domain.strategy.ManualNumberGeneration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 관련 객체 테스트")
public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void create() {
        lotto = new Lotto(new ManualNumberGeneration(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("당첨번호 중 맞춘 숫자 개수를 리턴")
    void 로또_당첨번호_count() {
        List<Integer> winList = new ArrayList<>(Arrays.asList(6, 5, 4, 10, 10, 10));
        Lotto winLotto = new Lotto(new ManualNumberGeneration(Arrays.asList(6, 5, 4, 10, 11, 12)));
        int count = lotto.countMath(winLotto);

        assertThat(count).isEqualTo(3);

    }

    @Test
    @DisplayName("로또번호에 보너스 볼 번호가 있는지 확인")
    void 보너스볼_유무_확인() {
        LottoNumber bonus = LottoNumber.valueOf(7);
        assertThat(lotto.contains(bonus)).isFalse();

    }
}
