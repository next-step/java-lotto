package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void shouldValidateLotto(){
        Assertions.assertThatThrownBy(()->new Lotto(List.of(1,1,1,1,1,1,1))).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void shouldReturnMatchedCount_whenOnlyUniqueNumberExist(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(lotto.getMatchedCount(new Lotto(List.of(1,2,3,4,8,9)))).isEqualTo(4);
    }

    @Test
    void shouldReturnMatchedCount_whenDuplicateNumberExist(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(lotto.getMatchedCount(new Lotto(List.of(1,2,3,4,4,9)))).isEqualTo(4);
    }
}
