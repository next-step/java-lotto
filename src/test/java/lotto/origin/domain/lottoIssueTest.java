package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class lottoIssueTest {
    lottoIssue lottos;

    @BeforeEach
    void setUp() {
        lottos = new lottoIssue(14000);
    }

    @Test
    @DisplayName("구입한 로또 개수 확인")
    void puchaseLottoCount() {
        assertThat(lottos.getCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 넘버 개수 확인")
    void confirmLottoNum() {
        List<Integer> result = lottos.selectionNumbers();
        assertThat(result).hasSize(6);
    }

    @Test
    @DisplayName("발행된 로또 개수 확인")
    void confirmLottoCount() {
        lottos.publishLotto(14);
        assertThat(lottos.getResult()).hasSize(14);
    }

    @Test
    @DisplayName("당첨통계 확인")
    void verifyStats() {
        ArrayList lotto = new ArrayList();
        lotto.add(1);
        lotto.add(3);
        lotto.add(5);
        lotto.add(11);
        lotto.add(19);
        lotto.add(40);
        String[] number = {"1","2","3","4","5","6"};

        int count = lottos.confrimLotto(lotto, number);
        assertThat(count).isEqualTo(3);
    }
}
