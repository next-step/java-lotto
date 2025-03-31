package domain.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    @Override
    public List<Integer> generate()  {
        List<Integer> allNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            allNumbers.add(i);
        }
        Collections.shuffle(allNumbers);
        List<Integer> lottoNumbers = allNumbers.subList(0, 6);
        Collections.sort(lottoNumbers);
        return new ArrayList<>(lottoNumbers);
    }
}
