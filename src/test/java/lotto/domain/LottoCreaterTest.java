package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCreaterTest {



    @DisplayName("로또생성기_생성 테스트")
    @Test
    public void 로또_금액만큼_로또발행하기() {
        assertThat(LottoCreater.issueLottos(1000)).hasSize(1);
    }

    @DisplayName("로또생성기_생성 테스트 여러개")
    @Test
    public void 로또_금액만큼_로또발행하기_여러개() {
        assertThat(LottoCreater.issueLottos(14000)).hasSize(14);
    }


    @DisplayName("랜덤숫자 가져오기 테스트(겹치지 않고, 1에서 45까지, 6개 숫자)")
    @Test
    public void 랜덤숫자가져오기_테스트() {
        assertThat(LottoCreater.getLottoNumbers()).hasSize(6);
        assertThat(LottoCreater.getLottoNumbers()).doesNotHaveDuplicates();
        assertThat(LottoCreater.getLottoNumbers()).containsAnyOf(LottoCreater.getLottoNumbers().toArray(new Integer[0]));
    }

    @DisplayName("로또 당첨번호 생성")
    @Test
    public void 당첨번호_생성() {
        assertThat(LottoCreater.issueWinningLottoNumbers()).hasSize(6);
        assertThat(LottoCreater.issueWinningLottoNumbers()).doesNotHaveDuplicates();
        assertThat(LottoCreater.issueWinningLottoNumbers()).containsAnyOf(LottoCreater.getLottoNumbers().toArray(new Integer[0]));
    }
}
