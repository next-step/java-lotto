package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class LottoTest {
    @DisplayName("로또 추첨번호는 1 ~ 45 이다.")
    @Test
    void lottoBallRange() {
        HashSet<Integer> checkSet = new HashSet<>();
        Arrays.stream(LottoBall.values()).forEach(lottoBall -> checkSet.add(lottoBall.getNumber()));
        Integer maxValue = Collections.max(checkSet);
        Integer minValue = Collections.min(checkSet);

        Assertions.assertThat(checkSet).hasSize(45);
        Assertions.assertThat(minValue).isEqualTo(1);
        Assertions.assertThat(maxValue).isEqualTo(45);
    }

    @DisplayName("6개의 랜덤 숫자를 추출한다.")
    @Test
    void getRandomNumber() {
        Lotto lotto = new Lotto();
        Assertions.assertThat(lotto.getNumbers()).hasSize(6);
    }


}
