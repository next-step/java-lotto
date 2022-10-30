import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    @Test
    public void buyLottoTest() {
        LottoService lottoService = new LottoService(() -> List.of(1, 2, 3, 4, 5, 6));
        List<List<Integer>> lottoList = lottoService.buyLotto(14000);

        assertThat(lottoList.size()).isEqualTo(14);
        assertThat(lottoList.get(0)).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void calculateWinningStatisticsTest() {
        //todo: 1등인 번호와 비교하여 제대로 WinningStatistics 객체를 반환하는지 테스트 코드 작성
        throw new RuntimeException("not implemented yet");
    }
}
