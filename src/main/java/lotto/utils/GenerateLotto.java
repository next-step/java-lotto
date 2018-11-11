package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@SuppressWarnings("FieldCanBeLocal")
public class GenerateLotto implements IGenerateLotto {

    private static int LOTTO_NUMBER_LENGTH = 6;
    private static int MAX_BOUND = 46;
    private static final Random RANDOM = new Random();

    public List<Integer> create() {
        return convertToList(pickRandom(LOTTO_NUMBER_LENGTH, MAX_BOUND));
    }

    private static List<Integer> convertToList(final Set<Integer> integers) {
        return integers.stream().map(Integer::new).sorted().collect(toList());
    }

    private static Set<Integer> pickRandom(final int n, final int k) {
        final Set<Integer> picked = new HashSet<>();
        while (picked.size() < n) {
            picked.add(RANDOM.nextInt(k));
        }
        return picked;
    }

}
