package lotto.step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoCreatorTest {
    @Test
    @DisplayName("생성된 로또의 번호 개수는 6개 입니다.")
    void createLotto() {
        Set<LottoNumber> lotto = LottoCreator.createLotto();
        assertThat(lotto.size()).isEqualTo(6);
    }
}