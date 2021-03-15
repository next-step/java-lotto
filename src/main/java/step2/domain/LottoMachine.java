package step2.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private static final int WIN_NUMBER_LENGTH = 6;
    private final Lottos lottos;

    public LottoMachine() {
        this.lottos = new Lottos();
    }

    //테스트를 위한 생성자
    public LottoMachine(Lottos lottos) {
        this.lottos = lottos;
    }

    public Lottos createLotto(int money) {
        return lottos.createLottoList(getLottoCount(money));
    }

    private int getLottoCount(int money) {
        if (money % LOTTO_PRICE != ZERO || money == ZERO) {
            throw new IllegalArgumentException("1000원 단위로 돈을 지불해주세요");
        }
        return BigDecimal.valueOf(money)
                .divide(BigDecimal.valueOf(LOTTO_PRICE))
                .intValue();
    }

    public List<Integer> getRankOfLottos(List<LottoNumber> winNumber) {
        return lottos.getRankOfLotto(winNumber);
    }

    public List<LottoNumber> toLottoNumberList(String winNumber) {
        String[] stringNumbers = winNumber.split(",");
        valid(stringNumbers);
        List<LottoNumber> collect;
        try {
            collect = Arrays.stream(stringNumbers)
                    .map(Integer::parseInt)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new RuntimeException("로또 당첨번호에 숫자가 아닌 부분이 있습니다.");
        }
        return collect;
    }

    private void valid(String[] stringNumbers) {
        if (stringNumbers.length != WIN_NUMBER_LENGTH) {
            throw new IllegalArgumentException("당첨번호가 6개가 아닙니다.");
        }
    }


}
