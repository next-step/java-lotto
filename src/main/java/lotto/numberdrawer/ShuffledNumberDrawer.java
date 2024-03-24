package lotto.numberdrawer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffledNumberDrawer implements NumberDrawer{
    @Override
    public List<Integer> drawnNumbers(int bound, int size) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= bound; i++) {
            result.add(i);
        }

        Collections.shuffle(result);

        return result.subList(0, size);
    }
}
