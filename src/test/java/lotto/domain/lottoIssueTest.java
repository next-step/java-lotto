package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class lottoIssueTest {
    lottoIssue lotto;

    @BeforeEach
    void setUp() {
        lotto = new lottoIssue(14000);
    }

    @Test
    @DisplayName("구입한 로또 개수 확인")
    void puchaseLottoCount() {
        assertThat(lotto.getCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 넘버 개수 확인")
    void lottoNum() {
        List<Integer> result = lotto.selectionNumbers();
        assertThat(result).hasSize(6);
    }

}
