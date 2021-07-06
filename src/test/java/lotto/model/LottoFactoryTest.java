package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoFactoryTest {
    LottoFactory lottoFactory;
    @BeforeEach
    void setUp() {
        lottoFactory = new LottoFactory();
    }
    @DisplayName(value = "자동 로또 갯수만큼 생성하기")
    @Test
    void create_auto_lottos() {
        List<Lotto> lottos = lottoFactory.createAutoLottos(3);
        for(Lotto lotto : lottos) {
            for(LottoNumber lottoNumber : lotto.getNumbers()) {
                System.out.print(lottoNumber.toString() + " ");
            }
            System.out.println();
        }
    }

    @DisplayName(value = "수동 로또 갯수만큼 생성하기")
    @Test
    void create_manual_lottos() {
        List<String> manualNumbers = new ArrayList<>();
        manualNumbers.add("1, 2, 3, 4, 5, 6");
        manualNumbers.add("2, 3, 4, 5, 6, 7");
        manualNumbers.add("3, 4, 5, 6, 7, 8");
        List<Lotto> lottos = lottoFactory.createManualLottos(3, manualNumbers);
        for(Lotto lotto : lottos) {
            for(LottoNumber lottoNumber : lotto.getNumbers()) {
                System.out.print(lottoNumber.toString() + " ");
            }
            System.out.println();
        }
    }
}
