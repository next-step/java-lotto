package lotto.helper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeConverter {

    private TypeConverter() {
    }

    public static List<List<Integer>> valueOf(int[][] numbers) {
        return Arrays.stream(numbers)
                .map(x -> Arrays.stream(x).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
