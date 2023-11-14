package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 관련 객체 테스트")
public class LottoTest {
    private String text;
    private Lotto lotto;

    @BeforeEach
    void create(){
        text = "[1, 2, 3, 4, 5, 6]";
        lotto = new Lotto(new TestNumberGeneration());
    }

    @Test
    @DisplayName("로또가 전략에 맞게 6개가 생성되는지 확인.")
    void 로또_생성_확인() {
        List<Integer> result = lotto.find();

        assertThat(result).hasSize(6);
        assertThat(result.toString()).isEqualTo(text);

    }

    @Test
    @DisplayName("당첨번호 중 맞춘 숫자 개수를 리턴")
    void 로또_당첨번호_count() {
        List<Integer> winList =  new ArrayList<>(Arrays.asList(6,5,4,10,10,10));
        int count = lotto.countMath(winList);

        assertThat(count).isEqualTo(3);

    }

    @Test
    @DisplayName("로또번호에 보너스 볼 번호가 있는지 확인")
    void 보너스볼_유무_확인() {
        int bonus = 7;
        assertThat(lotto.isHaveBonus(bonus)).isFalse();

    }
}
