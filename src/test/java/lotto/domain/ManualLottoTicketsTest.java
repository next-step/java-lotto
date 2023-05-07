package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("수동 로또 클래스 테스트")
class ManualLottoTicketsTest {

    @DisplayName("수동 로또 번호 문자열을 전달하면 수동 로또 객체 생성에 성공한다")
    @Test
    void manualLottoTicketsConstructor() {
        List<String> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add("1,2,3,4,5,6");
        manualLottoNumbers.add("2,3,4,5,6,7");
        manualLottoNumbers.add("3,4,5,6,7,8");

        ManualLottoTickets manualLottoTickets = new ManualLottoTickets(manualLottoNumbers);
        List<LottoTicket> lottoTickets = manualLottoTickets.fetchManualLottoTickets();

        Assertions.assertThat(lottoTickets.size()).isEqualTo(3);
    }
}
