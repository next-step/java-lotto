package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator(14);
    }

    @DisplayName("1~45 사이의 숫자 로또번호를 구매 수량 만큼 생성한다.")
    @Test
    void generateRandomNumbers() {
        LottoTicket lottoTicket = lottoGenerator.createLottoNumbersByPurchaseCount();
        assertThat(lottoTicket.getLottoNumbers()).hasSize(14);
    }


    @DisplayName("구매수량만큼 생성한 로또 번호들을 가져온다.")
    @Test
    void createLottoNumbersByPurchaseCount() {
        LottoTicket lottoTicket = lottoGenerator.getLottoTicket();
        assertThat(lottoTicket.getLottoNumbers()).hasSize(14);

    }
}
