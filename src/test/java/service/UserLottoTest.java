package service;

import domain.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.UserLottoRepository;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserLottoTest {
    UserLottoRepository userLottoRepository;
    UserLottoService userLottoService;

    @BeforeEach
    public void beforeEach() {
        userLottoRepository = new UserLottoRepository();
        userLottoService = new UserLottoService(userLottoRepository);
    }

    @AfterEach
    public void afterEach() {
        userLottoRepository.clearStore();
    }

    @Test
    @DisplayName("구입한 티켓 갯수에 맞춰 로또를 생성한다.")
    void generateLottoTest() {
        userLottoService.buyRandomLottoTickets(2);
        List<Lotto> lottoTickets = userLottoService.getAllLottoTickets();

        assertThat(lottoTickets.size()).isEqualTo(2);
    }


    @Test
    @DisplayName("수동 입력한 로또 번호에 맞춰 로또를 생성한다.")
    void generateManualLottoTest() {
        List<Integer> selectedNum = Arrays.asList(1, 2, 3, 4, 5, 6);
        userLottoService.buyManualLottoTickets(selectedNum);

        assertThat(userLottoRepository.getUserLottoTickets().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("사용자가 숫자를 중복 입력하는 경우 Exception throw")
    void wrongInputManualLottoExceptionTest() {
        List<Integer> selectedNum = Arrays.asList(1, 2, 3, 4, 5, 1);

        assertThrows(IllegalArgumentException.class, () -> userLottoService.buyManualLottoTickets(selectedNum));
    }

    @Test
    @DisplayName("사용자가 숫자를 6개 미만으로 입력하는 경우 Exception throw")
    void wrongInputManualLottoExceptionTest2() {
        List<Integer> selectedNum = Arrays.asList(1, 2, 3, 4, 5);

        assertThrows(IllegalArgumentException.class, () -> userLottoService.buyManualLottoTickets(selectedNum));
    }

    @Test
    @DisplayName("사용자가 숫자를 6개를 초과 입력하는 경우 Exception throw")
    void wrongInputManualLottoExceptionTest3() {
        List<Integer> selectedNum = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        assertThrows(IllegalArgumentException.class, () -> userLottoService.buyManualLottoTickets(selectedNum));
    }

    @Test
    @DisplayName("수동 입력한 로또번호가 45를 초과하는 경우 exception throw")
    void wrongInputManualLottoExceptionTest4() {
        List<Integer> selectedNum = Arrays.asList(1, 2, 3, 4, 5, 46);

        assertThrows(IllegalArgumentException.class, () -> userLottoService.buyManualLottoTickets(selectedNum));
    }

    @Test
    @DisplayName("수동 입력한 로또번호가 1 미만인 경우 exception throw")
    void wrongInputManualLottoExceptionTest5() {
        List<Integer> selectedNum = Arrays.asList(1, 2, 3, 4, 5, -1);

        assertThrows(IllegalArgumentException.class, () -> userLottoService.buyManualLottoTickets(selectedNum));
    }
}
