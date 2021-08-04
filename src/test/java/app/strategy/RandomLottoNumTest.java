package app.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoNumTest {

    @DisplayName("랜덤숫자 6개 생성 확인")
    @Test
    void makeLottoTest(){
        RandomLottoNum randomLotto = new RandomLottoNum();

        assertThat(randomLotto.makeLotto().getNumbers().size()).isEqualTo(6);
    }

}