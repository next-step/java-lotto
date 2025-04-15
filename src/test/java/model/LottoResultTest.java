package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.LottoService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    LottoResult result;
//    Placements placements;

    @BeforeEach
    public void setUp() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(4,5,6,7,8,9));
        Lotto lotto3 = new Lotto(List.of(1,2,3,7,10,11));
        Lottos lottos = new Lottos(List.of(lotto,lotto2,lotto3));
        String winningNumbersString = "1, 2, 3, 4, 7, 8";

        LottoService lottoService = new LottoService();
        result = lottoService.result(lottos, winningNumbersString);

//        this.placements = new Placements(List.of(
//                new Placement_Old(6, 2_000_000_000),
//                new Placement_Old(5, 1_500_000),
//                new Placement_Old(4, 50_000),
//                new Placement_Old(3, 5_000),
//                new Placement_Old(0, 0)
//        ));

    }

    @Test
    public void placementCountTest() {
        assertThat(result.placementCount(4)).isEqualTo(2);
        assertThat(result.placementCount(3)).isEqualTo(1);
    }

    @Test
    public void yieldTest() {
//        assertThat(result.yield(placements)).isEqualTo((double)105000/3000);
    }


}
