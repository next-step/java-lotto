package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
    }

    @Test
    @DisplayName("로또 번호 자동 생성")
    void 자동_생성() {
        assertThat(lotto.generateAutoLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("한 개의 로또에 일치하는 개수 확인")
    void 일치하는_개수_확인() {
        lotto = new Lotto(Arrays.asList(7, 2, 4, 5, 22, 37));
        assertThat(lotto.getMatchCount(Arrays.asList(1, 5, 13, 22, 43, 37))).isEqualTo(3);
    }
}
