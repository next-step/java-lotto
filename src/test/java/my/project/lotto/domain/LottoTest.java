package my.project.lotto.domain;

import my.project.constants.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created : 2020-11-23 오후 2:06
 * Developer : Seo
 */
class LottoTest {
    private Ticket info;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        this.info = new Ticket(14000);
        this.lotto = new Lotto();
    }

    @DisplayName("인스턴스 확인")
    @Test
    void init() {
        assertThat(lotto.games(info))
                .isNotNull()
                .isInstanceOf(ArrayList.class);
    }

    @DisplayName("1 게임은 6개의 숫자를 가진다")
    @Test
    void whenHaveGame_shouldSixNumbers() {
        assertThat(lotto.games(info).get(0).get()).hasSize(6);
    }

    @DisplayName("1 게임은 1과 45사이의 숫자를 가진다")
    @Test
    void whenHaveGame_shouldHaveBetween() {
        assertThat(lotto.games(info).get(0).get())
                .doesNotContain(Machine.MIN_NUMBER - 1)
                .doesNotContain(Machine.MAX_NUMBER + 1);
    }

    @DisplayName("1 게임은 중복되지 않는다")
    @Test
    void whenHaveGame_shouldNotHaveDuplicate() {
        assertThat(lotto.games(info).get(0).get()).doesNotHaveDuplicates();
    }

    @DisplayName("전체 회수를 구한다")
    @Test
    void whenMoney_thenToalCount() {
        assertThat(lotto.games(info)).hasSize(info.getCount());
    }

}
