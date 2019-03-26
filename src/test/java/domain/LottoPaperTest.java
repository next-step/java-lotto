package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoPaperTest {
    @Test
    public void 넣은_돈_만큼_입력지가_생성된다() {
        LottoPaper lottoPaper = new LottoPaper(new LottoMoney(15000));
        assertThat(lottoPaper.getElements()).hasSize(15);
    }

    @Test
    public void 수동번호_한줄을_입력한다() {
        LottoPaper lottoPaper = new LottoPaper(new LottoMoney(15000));
        lottoPaper.fillManual(NumberSet.fill(1,2,3,4,5,6));

        assertThat(lottoPaper.getManualCount()).isEqualTo(1);
        assertThat(lottoPaper.getAutoCount()).isEqualTo(14);
    }

    @Test
    public void 수동번호_여러줄을_입력한다() {
        LottoPaper lottoPaper = new LottoPaper(new LottoMoney(15000));
        lottoPaper.fillManuals(Arrays.asList(NumberSet.fill(1,2,3,4,5,6), NumberSet.fill(7,8,9,10,11,12)));

        assertThat(lottoPaper.getManualCount()).isEqualTo(2);
        assertThat(lottoPaper.getAutoCount()).isEqualTo(13);
    }
}
