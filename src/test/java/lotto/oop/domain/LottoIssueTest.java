package lotto.oop.domain;

import lotto.oop.domain.LottoIssue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoIssueTest {
    private LottoIssue lotto;

    @BeforeEach
    public void setUp() {
        lotto = new LottoIssue(14);
    }

    @Test
    @DisplayName("발행한 로또의 개수 확인")
    public void publishLootListTest() {
        assertThat(lotto.publishLottoList()).isEqualTo(14);
    }
}
