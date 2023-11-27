package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomLottoNumbers implements LottoNumbers {

    public List<Integer> lottoNumbers() {
        List<Integer> shuffledLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.shuffle(shuffledLottoNumbers);
        return shuffledLottoNumbers.subList(0, 6).stream().sorted().collect(Collectors.toList());
    }
}
