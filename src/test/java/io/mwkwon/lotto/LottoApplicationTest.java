package io.mwkwon.lotto;

import io.mwkwon.lotto.domain.*;
import io.mwkwon.lotto.interfaces.DataGenerator;
import io.mwkwon.lotto.interfaces.LottoGenerator;
import io.mwkwon.lotto.view.ResultView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoApplicationTest {

    @Test
    void 로또_통합_테스트() {

        DataGenerator dataGenerator = new DataGenerator() {
            @Override
            public LottoPayment requestInputPayment() {
                System.out.println("구입금액을 입력해 주세요.");
                return new LottoPayment("14000");
            }

            @Override
            public Lotto requestWinningLottoNumbers() {
                System.out.println("지난 주 당첨 번호를 입력해 주세요.");
                return new Lotto("1, 2, 3, 4, 5, 6");
            }

            @Override
            public LottoNumber requestBonusBallNumber(Lotto winningLotto) {
                System.out.println("보너스 볼을 입력해 주세요.");
                return new LottoNumber("7");
            }
        };

        LottoGenerator lottoGenerator = (lottoPayment) -> {
            List<Lotto> lottos = Arrays.asList(
                    new Lotto("8, 21, 23, 41, 42, 43"),
                    new Lotto("3, 5, 11, 16, 32, 38"),
                    new Lotto("7, 11, 16, 35, 36, 44"),
                    new Lotto("1, 8, 11, 31, 41, 42"),
                    new Lotto("13, 14, 16, 38, 42, 45"),
                    new Lotto("7, 11, 30, 40, 42, 43"),
                    new Lotto("2, 13, 22, 32, 38, 45"),
                    new Lotto("23, 25, 33, 36, 39, 41"),
                    new Lotto("1, 3, 5, 14, 22, 45"),
                    new Lotto("5, 9, 38, 41, 43, 44"),
                    new Lotto("2, 8, 9, 18, 19, 21"),
                    new Lotto("13, 14, 18, 21, 23, 35"),
                    new Lotto("17, 21, 29, 37, 42, 45"),
                    new Lotto("3, 8, 27, 30, 35, 44")
            );
            return new BuyLottos(lottos);
        };
        LottoApplication lottoApplication = new LottoApplication(dataGenerator, new ResultView(), lottoGenerator);
        lottoApplication.run();
    }
}
