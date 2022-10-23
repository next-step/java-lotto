package lotto.domain.lotto;

import lotto.domain.lottonumber.LottoNumberSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoListTest {

    private Lotto lotto;

    @BeforeEach
    public void setLotto() {
        lotto = new Lotto(1, 2, 3, 4, 5, 6);
    }

    @Test
    void create() {
        LottoList lottoList = new LottoList(Arrays.asList(lotto));
        assertThat(lottoList).isEqualTo(new LottoList(Arrays.asList(lotto)));
    }

    @Test
    void size() {
        LottoList lottoList = new LottoList(Arrays.asList(lotto));
        assertThat(lottoList.size()).isEqualTo(1);
    }

    @Test
    void addAll_size() {
        LottoList lottoList = new LottoList(Arrays.asList(lotto));
        List<Lotto> lottos = List.of(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(1, 2, 3, 4, 5, 6));

        assertThat(lottoList.addAll(new LottoList(lottos)).size()).isEqualTo(3);
    }
}
