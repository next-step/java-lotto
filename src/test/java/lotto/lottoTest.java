package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoNumber;
import lotto.service.LottoMachine;
import lotto.service.LottoPurchases;
import lotto.service.LottoResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class lottoTest {
    private LottoPurchases lottoPurchasesService;
    private LottoMachine lottoMachineService;
    private List<LottoNumber> purchasesLottoList = new ArrayList<>();

    @ValueSource(ints = {10000})
    @ParameterizedTest
    public void 구매금액에_따라_로또번호가_생성_되어야한다(final int ints) {
        lottoPurchasesService = new LottoPurchases(ints);
        for (int i = 0; i < lottoPurchasesService.getLottoMachineCount(); i++){
            lottoMachineService = new LottoMachine();
            purchasesLottoList.add(i, lottoMachineService.getLottoNumberList());
        }
    }

    @ValueSource(ints = {1000})
    @ParameterizedTest
    public void 로또_당첨에_따라_통계_및_수익률이_나와야한다(final int ints) {
        final int bonusBall = 8;
        List<Integer> numberData = Arrays.asList(1,2,3,4,5,6);
        LottoNumber resultLottoNumber = new LottoNumber(numberData);

        lottoMachineService = new LottoMachine();
        purchasesLottoList.add(0, lottoMachineService.getLottoNumberList());

        new LottoResult(purchasesLottoList, resultLottoNumber, ints, bonusBall);
    }

    @ValueSource(strings = {"30,29,11,12,18,14,1"})
    @ParameterizedTest
    void 이전_로또_당첨번호는_6자리이다(String strings) {
        assertThat(LottoController.numberSet(strings));
    }
}
