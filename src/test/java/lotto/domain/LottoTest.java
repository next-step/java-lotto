package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("순서와 관계없이 번호가 동일하면 같은 로또다")
    @Test
    void equals(){
        Lotto lotto1 = new Lotto("1,2,3,4,5,6");
        Lotto lotto2 = new Lotto("2,6,4,5,3,1");

        assertThat(lotto1.equals(lotto2)).isTrue();
    }

}