package lottoGame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoShuffle {
    private static List<LottoNumber> totalNumbers = new ArrayList<>(LottoNumber.getLottoNumbers().values());

    public static List<LottoNumber> shuffle() {
        Collections.shuffle(totalNumbers);
        return totalNumbers;
    }
}
