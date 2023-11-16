package lotto.step2.domain;

import lotto.step2.input.UserInput;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final List<Integer> SHUFFLE_LOTTO_NUMBERS = new ArrayList<>();

    static {
        for (int i = 1; i <= 45; i++) {
            SHUFFLE_LOTTO_NUMBERS.add(i);
        }
    }

    private LottoGenerator() {
        throw new IllegalStateException("static class");
    }

    public static List<Lotto> generateLottos(final UserInput input) {
        List<Lotto> lottos = new ArrayList<>();

        lottos.addAll(input.getPassiveLottos());
        lottos.addAll(generateAutoLottos(input.getAutoLottoCount()));

        return lottos;
    }

    private static List<Lotto> generateAutoLottos(final int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(generateRandomIntegerSetOfSize6()));
        }

        return lottos;
    }

    public static Lotto generatePassiveLottos(final String inputStringLine) {
        final Set<Integer> integers = Arrays.stream(inputStringLine.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        return new Lotto(integers);
    }

    private static Set<Integer> generateRandomIntegerSetOfSize6() {
        Collections.shuffle(SHUFFLE_LOTTO_NUMBERS);

        return new HashSet<>(SHUFFLE_LOTTO_NUMBERS.subList(0, 6));
    }
}
