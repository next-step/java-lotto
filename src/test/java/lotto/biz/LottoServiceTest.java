package lotto.biz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class LottoServiceTest {

    @Test
    @DisplayName("구입금액 입력후 Lotto 갯수 결과 출력")
    void when_input_purchase_value_print_lotto_game_count() {
        LottoService service = new LottoService();
        service.setPurchaseValue(200000);

        assertThat(service.getGames().size()).isEqualTo(200);
    }

    @Test
    @DisplayName("담청 번호 입력이 가능하다")
    void setWinningNumbers() {
        LottoService service = new LottoService();
        service.setPurchaseValue(14000);
        service.setWinningNumbers("13, 2, 38, 4, 5, 6");

        assertThat(service.getWinningNumbers())
                .contains(13)
                .contains(2)
                .contains(38);
    }

    @Test
    @DisplayName("2등을 위해 추가 번호를 하나 더 입력")
    void setBonusNumber(){
        LottoService service = new LottoService();
        service.setBonusNumber("19");

        assertThat(service.getBonusNumber()).isEqualTo(19);
    }

    @Test
    @DisplayName("수동 구매 로또 수 입력 테스트")
    void input_manual_lotto_count_test(){
        LottoService service = new LottoService();
        service.setManualLottoCount(5);

        assertThat(service.getManualLottoCount()).isEqualTo(5);
    }


    @Test
    @DisplayName("수동 구매 로또 수 0이상일 경우 번호 수동 입력테스트")
    void when_manual_lotto_count_over_one_test(){
        LottoService service = new LottoService();
        service.setPurchaseValue(14000);
        service.setManualLottoCount(3);

        assertThat(service.getManualLottoCount()).isEqualTo(5);
    }

}