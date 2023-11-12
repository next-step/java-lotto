package step2;

import step2.util.GeneratorUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int PRICE_PER_LOTTO = 1_000;

    public List<Lotto> createLottos(int inputMoney) {
        inputCheck(inputMoney);
        return lottoList(inputMoney/ PRICE_PER_LOTTO);
    }

    private void inputCheck(int inputMoney) {
        if (inputMoney < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException(String.format("로또 구입 금액은 최소 $d 이상이어야 합니다.", PRICE_PER_LOTTO));
        }

        if ((inputMoney % PRICE_PER_LOTTO) != 0) {
            throw new IllegalArgumentException(String.format("로또 구입 금액은 $d의 배수여야합니다.", PRICE_PER_LOTTO));
        }
    }

    private List<Lotto> lottoList(int requestCount) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < requestCount; i++) {
            result.add(generateLotto());
        }
        return result;
    }


    private Lotto generateLotto() {
        return new Lotto(GeneratorUtil.randomNumbers(LOTTO_LAST_NUMBER, LOTTO_SIZE));
    }
}
