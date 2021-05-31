package io.mwkwon.lotto;

import io.mwkwon.lotto.domain.*;
import io.mwkwon.lotto.interfaces.DataGenerator;
import io.mwkwon.lotto.interfaces.LottoGenerator;
import io.mwkwon.lotto.view.ResultView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoApplicationTest {

    @Test
    void 로또_통합_테스트() {

        DataGenerator dataGenerator = new DataGenerator() {
            @Override
            public LottoPayment requestInputPayment() {
                System.out.println("구입금액을 입력해 주세요.");
                return LottoPayment.create(14000);
            }

            @Override
            public Lotto requestWinningLottoNumbers() {
                System.out.println("지난 주 당첨 번호를 입력해 주세요.");
                List<LottoNumber> lottoNumbers = Arrays.asList(
                        LottoNumber.create(1),
                        LottoNumber.create(2),
                        LottoNumber.create(3),
                        LottoNumber.create(4),
                        LottoNumber.create(5),
                        LottoNumber.create(6));
                return Lotto.create(lottoNumbers);
            }

            @Override
            public LottoNumber requestBonusBallNumber(Lotto winningLotto) {
                System.out.println("보너스 볼을 입력해 주세요.");
                return LottoNumber.create(7);
            }

            @Override
            public PurchaseQuantity requestManualLottoPurchaseQuantity(LottoPayment lottoPayment) {
                return PurchaseQuantity.create(3);
            }

            @Override
            public List<LottoNumbers> requestManualLottoNumbers(PurchaseQuantity purchaseQuantity) {
                return Arrays.asList(
                        LottoNumbers.create(Stream.of("8, 21, 23, 41, 42, 43".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber.trim()))).collect(Collectors.toList())),
                        LottoNumbers.create(Stream.of("3, 5, 11, 16, 32, 38".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber.trim()))).collect(Collectors.toList())),
                        LottoNumbers.create(Stream.of("7, 11, 16, 35, 36, 44".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber.trim()))).collect(Collectors.toList()))
                );
            }
        };

        LottoGenerator lottoGenerator = new LottoMachine() {
            @Override
            public BuyLottos createAutoLottos(PurchaseQuantity purchaseQuantity) {
                return  BuyLottos.create(Arrays.asList(
                        Lotto.create(Stream.of("1, 8, 11, 31, 41, 42".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber.trim()))).collect(Collectors.toList())),
                        Lotto.create(Stream.of("13, 14, 16, 38, 42, 45".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber.trim()))).collect(Collectors.toList())),
                        Lotto.create(Stream.of("7, 11, 30, 40, 42, 43".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber.trim()))).collect(Collectors.toList())),
                        Lotto.create(Stream.of("2, 13, 22, 32, 38, 45".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber.trim()))).collect(Collectors.toList())),
                        Lotto.create(Stream.of("23, 25, 33, 36, 39, 41".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber.trim()))).collect(Collectors.toList())),
                        Lotto.create(Stream.of("1, 3, 5, 14, 22, 45".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber.trim()))).collect(Collectors.toList())),
                        Lotto.create(Stream.of("5, 9, 38, 41, 43, 44".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber.trim()))).collect(Collectors.toList())),
                        Lotto.create(Stream.of("2, 8, 9, 18, 19, 21".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber.trim()))).collect(Collectors.toList())),
                        Lotto.create(Stream.of("13, 14, 18, 21, 23, 35".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber.trim()))).collect(Collectors.toList())),
                        Lotto.create(Stream.of("17, 21, 29, 37, 42, 45".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber.trim()))).collect(Collectors.toList())),
                        Lotto.create(Stream.of("3, 8, 27, 30, 35, 44".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber.trim()))).collect(Collectors.toList()))
                ));
            }
        };
        LottoApplication lottoApplication = new LottoApplication(dataGenerator, new ResultView(), lottoGenerator);
        lottoApplication.run();
    }
}
