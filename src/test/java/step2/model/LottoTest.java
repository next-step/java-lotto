package step2.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void 로또는_로또번호가_같으면_같다() {
        Lotto lotto1 = new Lotto(new int[]{1, 2, 3, 4, 5, 6});
        Lotto lotto2 = new Lotto(new int[]{1, 2, 3, 4, 5, 6});
        assertThat(lotto1).isEqualTo(lotto2);
    }

    @Test
    public void 로또가_보너스번호를_포함여부_테스트() {
        Lotto lotto = new Lotto(new int[]{1, 2, 3, 4, 5, 6});
        LottoNumber bonusNumber = new LottoNumber(1);

        assertThat(lotto.containsLottoNumber(bonusNumber)).isTrue();
    }

    @Test
    public void 로또끼리_일치하는_번호_개수_반환_테스트() {
        Lotto lottoA = new Lotto(new int[]{1, 2, 3, 4, 5, 6});
        Lotto lottoB = new Lotto(new int[]{1, 2, 3, 7, 8, 9});


        assertThat(lottoA.compareToMatchNumberCount(lottoB)).isEqualTo(3);
    }
}
