package lotto.domain;

import lotto.util.Split;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoMemoTest {

    @DisplayName("로또 String 목록에 대한 Memo 객체가 정상적으로 생성된다.")
    @Test
    void ofTest() {
        String lottoMemo1 = "1,2,3,4,5,6";
        String lottoMemo2 = "1,2,3,7,5,8";

        ManualLottoMemo manualLottoMemo = ManualLottoMemo.of(List.of(lottoMemo1, lottoMemo2));

        assertThat(manualLottoMemo).isNotNull();
        assertThat(manualLottoMemo.getLottoMemos()).contains(
                LottoNumberPool.get(Split.from(lottoMemo1, ",")),
                LottoNumberPool.get(Split.from(lottoMemo2, ",")));
    }

    @DisplayName("Memo의 기록된 로또번호들이 정상적으로 생성된다.")
    @Test
    void getLottoMemosTest() {
        ManualLottoMemo manualLottoMemo = ManualLottoMemo.of(List.of("1,2,3,4,5,6", "2,3,4,5,6,7"));
        List<List<LottoNumber>> lottoMemo = manualLottoMemo.getLottoMemos();

        assertThat(lottoMemo.size()).isEqualTo(2);
        assertThat(lottoMemo).contains(LottoNumberPool.get(1,2,3,4,5,6), LottoNumberPool.get(2,3,4,5,6,7));
    }

    @DisplayName("입력할 로또번호들이 없어도 메모가 정상적으로 생성된다.")
    @Test
    void getLottoMemoNullEmptyTest() {
        ManualLottoMemo manualLottoMemoCase1 = ManualLottoMemo.of(null);
        ManualLottoMemo manualLottoMemoCase2 = ManualLottoMemo.empty();

        assertThat(manualLottoMemoCase1.isEmpty()).isTrue();
        assertThat(manualLottoMemoCase2.isEmpty()).isTrue();
    }

    @DisplayName("입력한 로또번호들의 수를 정상적으로 얻을 수 있다.")
    @Test
    void getSizeTest() {
        ManualLottoMemo manualLottoMemo = ManualLottoMemo.of(List.of("1,2,3,4,5,6", "2,3,4,5,6,7"));

        assertThat(manualLottoMemo.size()).isEqualTo(2);
    }
}