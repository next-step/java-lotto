package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        System.out.println("자동 로또 갯수만큼 생성하기");
        for (Lotto lotto : lottos) {
            for (LottoNumber lottoNumber : lotto.getNumbers()) {
                System.out.print(lottoNumber.toString() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
