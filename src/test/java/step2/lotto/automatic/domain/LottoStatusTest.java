package step2.lotto.automatic.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoStatusTest {

    private static LottoStatus lottoStatus;

    @Test
    public void 로또_등수_외_값_입력_체크() {
        assertThatThrownBy(() ->
                lottoStatus = new LottoStatus(100)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 로또_당첨_횟수_증가_체크() {
        lottoStatus = new LottoStatus(1);
        lottoStatus.addLottoWinning();
        lottoStatus.addLottoWinning();

        assertThat(lottoStatus.getWinningCount()).isEqualTo(2);
    }

    @Test
    public void 로또_누적_금액_증가_체크() {
        lottoStatus = new LottoStatus(2);
        lottoStatus.addLottoWinning();
        lottoStatus.addLottoWinning();

        assertThat(lottoStatus.getCumulativeAmount()).isEqualTo(3000000);
    }


    @Test
    public void 로또_맞춰야_되는_번호_갯수_체크() {
        lottoStatus = new LottoStatus(2);

        assertThat(lottoStatus.getSameCount()).isEqualTo(5);
    }


}
