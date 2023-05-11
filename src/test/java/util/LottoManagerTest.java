package util;

import domain.Lotto;
import domain.LottoResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoManagerTest {

    @Test
    @DisplayName("아무 조건 없이 로또를 생성한다")
    void createLotto() {
        Lotto lotto = LottoManager.createLotto();
        assertThat(lotto).isNotNull();
    }
}