package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoCreator {

    public static List<Lotto>  createLottos(List<String> lottoNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (String numbers : lottoNumbers) {
            String[] splitNumbers = numbers.split(", ");
            lottos.add(new Lotto(Arrays.stream(splitNumbers).map(Integer::parseInt).collect(Collectors.toList())));
        }
        return lottos;
    }
}
