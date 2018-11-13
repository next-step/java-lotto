package lotto.utils;

import java.util.*;
import java.util.stream.Collectors;

public class GenerateLotto {

    private static final int MAX_BOUND = 46;
    private static final int LOTTO_NUMBER_LENGTH = 6;
    private static final Random RANDOM = new Random();

    public static List<Integer> create() {
        return convertToList(pickRandom(LOTTO_NUMBER_LENGTH, MAX_BOUND));
    }

    public static List<Integer> create(String number) {
        return toList(split(number));
    }

    private static String[] split(final String number) {
        return number.split(",");
    }

    private static List<Integer> toList(final String[] number) {
        final List<Integer> ints = new ArrayList<>();
        for (Integer num : toInts(number)) {
            ints.add(num);
        }
        return ints;
    }

    private static int[] toInts(final String[] number) {
        final int[] ints = new int[number.length];
        for (int i = 0; i < number.length; i++) {
            ints[i] = convertInt(number[i]);
        }
        return ints;
    }

    private static int convertInt(final String text) {
        return Integer.parseInt(text);
    }

    private static List<Integer> convertToList(final Set<Integer> integers) {
        return integers.stream().map(Integer::new).sorted().collect(Collectors.toList());
    }

    private static Set<Integer> pickRandom(final int n, final int k) {
        final Set<Integer> picked = new HashSet<>();
        while (picked.size() < n) {
            picked.add(RANDOM.nextInt(k));
        }
        return picked;
    }

}
