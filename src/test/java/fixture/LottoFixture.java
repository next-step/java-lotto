package fixture;

import lotto.domain.Lotto;
import lotto.domain.LottoNum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFixture {

    public static Lotto createLottoFixture(int... lottoNumbers) {
        List<LottoNum> lottoNums = Arrays.stream(lottoNumbers)
                .mapToObj(LottoNum::new)
                .collect(Collectors.toList());
        return new Lotto(lottoNums);
    }
}
