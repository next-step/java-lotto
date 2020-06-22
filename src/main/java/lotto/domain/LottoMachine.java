package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static List<Lotto> createManualLottos(List<String> lottoNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (String numbers : lottoNumbers) {
            String[] splitNumbers = numbers.split(", ");

            lottos.add(new Lotto(Arrays.stream(splitNumbers)
                    .map(LottoMachine::parseInt)
                    .sorted()
                    .collect(Collectors.toList())));
        }
        return lottos;
    }

    public static List<Lotto> createAutoLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int idx = 0; idx < lottoCount; idx++) {
            lottos.add(new Lotto(raffle()));
        }
        return lottos;
    }

    private static List<Integer> raffle() {
        List<Integer> numbers = new ArrayList<>(LottoNumber.getNumbers().keySet());
        Collections.shuffle(numbers);
        return numbers.subList(0, 6).stream()
                .sorted().collect(Collectors.toList());
    }

    private static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자가 아닙니다.");
        }
    }
}
