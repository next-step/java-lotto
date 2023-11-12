package step2.domain;

import step2.util.GeneratorUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int PRICE_PER_LOTTO = 1_000;

    public Lottos createLottos(int inputMoney) {
        inputCheck(inputMoney);
        return lottoList(inputMoney/ PRICE_PER_LOTTO);
    }

    private void inputCheck(int inputMoney) {
        if (inputMoney < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException(String.format("로또 구입 금액은 최소 $d 이상이어야 합니다. 입력값 : $d", PRICE_PER_LOTTO, inputMoney));
        }

        if ((inputMoney % PRICE_PER_LOTTO) != 0) {
            throw new IllegalArgumentException(String.format("로또 구입 금액은 $d의 배수여야합니다. 입력값 : $d", PRICE_PER_LOTTO, inputMoney));
        }
    }

    private Lottos lottoList(int requestCount) {
        Lottos result = new Lottos();
        for (int i = 0; i < requestCount; i++) {
            result.addLotto(generateLotto());
        }
        return result;
    }

    private Lotto generateLotto() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for(int number : GeneratorUtil.randomNumbers(LOTTO_LAST_NUMBER, LOTTO_SIZE)){
            lottoNumbers.add(LottoNumber.of(number));
        }
        return new Lotto(lottoNumbers);
    }
}
