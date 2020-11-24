package step4.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTicketMakerTest {

    private static final List<Lotto> lottos = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        Lotto lotto = new Lotto();
        lotto.getLottos().clear();
        IntStream.of(1, 2, 3, 7, 8, 9).forEach(i -> lotto.getLottos().add(i));

        lottos.add(lotto);
    }

    @ParameterizedTest
    @DisplayName("입력한 로또 가격 만큼 티켓 생성 갯수 확인")
    @ValueSource(ints = {14})
    public void 입력한_로또_가격_확인(int lottoAmount) {
        int manualLottoQty = 0;
        List<Lotto> manualLottoNumbers = new ArrayList<>();
        LottoTicketMaker lottoTicketMaker = LottoTicketMaker.of(14000, manualLottoQty, manualLottoNumbers);
        assertEquals(lottoAmount, lottoTicketMaker.lottoAutoPurchaseQty() + manualLottoQty);
    }

    @ParameterizedTest
    @DisplayName("입력한 수동 갯수 제외한 자동 갯수 확인")
    @ValueSource(ints = {13})
    public void 입력한_수동_갯수_제외_자동_갯수_확인(int lottoAmount) {
        int manualLottoQty = 1;
        LottoTicketMaker lottoTicketMaker = LottoTicketMaker.of(14000, manualLottoQty, lottos);
        assertEquals(lottoAmount, lottoTicketMaker.lottoAutoPurchaseQty());
    }
}
