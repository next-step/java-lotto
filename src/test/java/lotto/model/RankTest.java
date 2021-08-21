package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class RankTest {

    @Test
    void 범위_밖의_숫자_넣을경우_예외처리(){
        assertThatThrownBy(()->
            Rank.of(7,true)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
