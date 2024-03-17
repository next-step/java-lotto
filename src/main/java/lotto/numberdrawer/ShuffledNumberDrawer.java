package lotto.numberdrawer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ShuffledNumberDrawer implements NumberDrawer{
    @Override
    public List<Integer> drawnNumbers(int bound, int size) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= bound; i++) {
            result.add(bound);
        }

        Collections.shuffle(result);

        return result.subList(0, size).stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
