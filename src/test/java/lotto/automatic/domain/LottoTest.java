package lotto.automatic.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트 ")
    public void creation_로또_인스턴스() {

        Lotto lotto1 = new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto1.equals(lotto2)).isTrue();
    }

    @Test
    @DisplayName("로또 번호가 잘못된 경우 ")
    public void 로또번호에_46_이_있는경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 46))
                );
    }

    @Test
    @DisplayName("로또 번호가 6개를 넘는 경우")
    public void 로또번호가_6개를_넘는_경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
                );
    }

    @Test
    @DisplayName("로또 번호가 6개에 못미치는 경우")
    public void 로또번호가_5개인_경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5))
                );
    }

    @Test
    @DisplayName("매치 카운트 테스트")
    public void matchCountTest() {

        Lotto lotto = new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1));
        int matchCount = lotto.matchCount(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(matchCount).isEqualTo(6);

    }


}
