package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface LottoNumberStrategy {
    default List<Integer> create() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list.subList(0, 6);
    }
}
