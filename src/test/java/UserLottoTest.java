import domain.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.UserLottoRepository;
import service.UserLottoService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserLottoTest {
    UserLottoRepository userLottoRepository;
    UserLottoService userLottoService;

    @BeforeEach
    public void beforeEach() {
        userLottoRepository = new UserLottoRepository();
        userLottoService = new UserLottoService(userLottoRepository);
    }

    @AfterEach
    public void afterEach(){
        userLottoRepository.clearStore();
    }

    @Test
    @DisplayName("구입한 티켓 갯수에 맞춰 로또를 생성한다.")
    void generateLottoTest() {
        userLottoService.buyRandomLottoTickets(2000);
        userLottoService.getAllLottoTickets();

        for (Lotto lotto : lottoTicket) {
            System.out.println("lotto1.getLottoNumbers() = " + lotto.getLottoNumbers());
        }
        assertThat(lottoTicket.size()).isEqualTo(2);
    }
}
