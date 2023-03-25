package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {

    @DisplayName("중복되지 않은 6개의 로또 테스트")
    @Test
    void validLottoTest() {
        List<LottoBall> balls = Arrays.asList(new LottoBall(1), new LottoBall(2),
                new LottoBall(3), new LottoBall(4), new LottoBall(5), new LottoBall(6));
        Lotto lotto = new Lotto(balls);
        assertThat(lotto.getBalls().size()).isEqualTo(6);
    }

    @DisplayName("중복되는 숫자를 가진 로또 테스트")
    @Test
    void duplicateNumberLottoTest() {
        List<LottoBall> balls = Arrays.asList(new LottoBall(1), new LottoBall(1),
                new LottoBall(3), new LottoBall(4), new LottoBall(5), new LottoBall(6));
        assertThrows(IllegalArgumentException.class, () -> {
            Lotto lotto = new Lotto(balls);
        });
    }
    
    @DisplayName("5개의 숫자를 가진 로또 테스트")
    @Test
    void invalidNumberCountLottoTest() {
        List<LottoBall> balls = Arrays.asList(new LottoBall(1), new LottoBall(2),
                new LottoBall(3), new LottoBall(4), new LottoBall(5));
        assertThrows(IllegalArgumentException.class, () -> {
            Lotto lotto = new Lotto(balls);
        });
    }

}