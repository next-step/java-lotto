package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoService implements LottoCreateService {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;


    @Override
    public List<Integer> getLotto() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.add(i);
        }
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, LOTTO_SIZE);
    }
}
