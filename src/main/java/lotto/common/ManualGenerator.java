package lotto.common;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualGenerator {

    public static List<Lotto> generate(List<String> lottoNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (String number : lottoNumbers) {
            String[] splitNumbers = number.split(",");
            lottos.add(convertToLotto(splitNumbers));
        }
        return lottos;
    }

    private static Lotto convertToLotto(String[] splitNumbers) {
        List<Integer> lottoNumbers = Arrays.stream(splitNumbers)
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());
     return new Lotto(lottoNumbers);
    }
}
