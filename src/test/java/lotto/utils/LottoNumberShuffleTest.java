package lotto.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberShuffleTest {

    private  LottoShuffle lottoShuffle;

    @BeforeEach
    void setUp() {
        lottoShuffle = new LottoShuffle();
    }

    @DisplayName("Shuffle타입의 로또 번호 생성 테스트")
    @Test
    void makeLottoNumber() {
        List numbers = lottoShuffle.makeLottoNumber();
        assertThat(numbers.size()).isEqualTo(6);
    }
}