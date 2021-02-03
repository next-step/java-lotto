package lotto.controller;

import java.util.HashMap;
import java.util.Map;

public class MatchLookUpTable {
    public static final Map<Integer, Integer> lookUpTable = new HashMap<>();

    static {
        lookUpTable.put(0, 3);
        lookUpTable.put(1, 4);
        lookUpTable.put(2, 5);
        lookUpTable.put(3, 5);
        lookUpTable.put(4, 6);
    }
}
