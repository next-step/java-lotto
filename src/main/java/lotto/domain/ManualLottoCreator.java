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
            validateNumbersLength(splitNumbers);

            lottos.add(new Lotto(Arrays.stream(splitNumbers)
                    .map(ManualLottoCreator::parseInt)
                    .sorted()
                    .collect(Collectors.toList())));
        }
        return lottos;
    }

    private static void validateNumbersLength(String[] splitNumbers) {
        if (splitNumbers.length != 6) {
            throw new IllegalArgumentException("로또 숫자가 부족합니다.");
        }
    }

    private static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자가 아닙니다.");
        }
    }
}
