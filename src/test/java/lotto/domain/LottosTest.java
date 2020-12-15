package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LottosTest {

    @Test
    @DisplayName("로또번호들을 생성하고 주어진 만큼 생성되었는지 테스트")
    public void createLottos() {
        // given
        Lottos lottos = new Lottos();
        
        // when
        lottos.addLotto(new Lotto());
        lottos.addLotto(new Lotto());
        lottos.addLotto(new Lotto());
        
        
        // then
        assertThat(lottos.size()).isEqualTo(3);
    }
}