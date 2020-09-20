package step2;

import org.junit.jupiter.api.Test;
import step2.controller.FindMatchNumber;
import step2.controller.IssueLotto;
import step2.controller.Rank;
import step2.domain.LottoNo;
import step2.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 로또_개수() {
        int result = new IssueLotto().create(14000);
        assertThat(result).isEqualTo(14);
    }

    @Test
    void 자동_로또번호() {
        LottoNo lottoNo = new IssueLotto().issueLotto();
        System.out.println(lottoNo);
//        assertThat(lottoNo.).isEqualTo(6);
    }

    @Test
    void 여러개_자동_로또번호() {
        List<LottoNo> lottos = new IssueLotto().issueLottos(7);
        assertThat(lottos.size()).isEqualTo(7);
    }

    @Test
    void view() {
        List<LottoNo> lottos = new IssueLotto().issueLottos(7);
        ResultView.view(lottos);
    }

    @Test
    void 당첨번호_와_일치하는_번호_갯수() {
        String winningNumber = "8,21,23,41,42,43";
        assertThat(FindMatchNumber.find(Arrays.asList(8, 10, 23, 41, 44, 45), winningNumber))
                .isEqualTo(3);
        assertThat(FindMatchNumber.find(Arrays.asList(3, 5, 11, 16, 32, 38), winningNumber))
                .isEqualTo(0);
        assertThat(FindMatchNumber.find(Arrays.asList(8, 10, 23, 40, 44, 45), winningNumber))
                .isEqualTo(2);
        assertThat(FindMatchNumber.find(Arrays.asList(8, 9, 10, 11, 20, 45), winningNumber))
                .isEqualTo(1);
        assertThat(FindMatchNumber.find(Arrays.asList(8, 21, 23, 41, 44, 45), winningNumber))
                .isEqualTo(4);
        assertThat(FindMatchNumber.find(Arrays.asList(8, 21, 23, 41, 42, 45), winningNumber))
                .isEqualTo(5);
        assertThat(FindMatchNumber.find(Arrays.asList(8, 21, 23, 41, 42, 43), winningNumber))
                .isEqualTo(6);

    }

    @Test
    void 당첨_통계() {
        List<LottoNo> lottos = new ArrayList<>();

        lottos.add(new LottoNo(8, 10, 23, 41, 44, 45)); // 3일치
        lottos.add(new LottoNo(8, 21, 22, 41, 44, 45)); // 3일치
        lottos.add(new LottoNo(8, 10, 23, 41, 44, 45)); // 3일치
        lottos.add(new LottoNo(8, 21, 23, 41, 42, 45)); // 5일치
        lottos.add(new LottoNo(8, 21, 23, 41, 42, 43)); // 6일치

        String winningNumber = "8,21,23,41,42,43";
        int[] result = Rank.result(lottos, winningNumber);
        System.out.println(result[0]);
        assertThat(result).containsExactly(3, 0, 1, 1);

    }

}
