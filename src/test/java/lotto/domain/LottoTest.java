package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 로또들이_주어졌을_때_동등성_확인을_할_수_있다(){
        //given
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 7)));
        //when
        //then
        assertThat(lotto).isEqualTo(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 7))));
    }
}
