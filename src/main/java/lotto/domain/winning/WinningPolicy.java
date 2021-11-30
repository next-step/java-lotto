package lotto.domain.winning;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WinningPolicy {

    public static final Map<Integer, Integer> MATCHING_WINNINGAMOUNT_MAP =
            Collections.unmodifiableMap(new HashMap<Integer, Integer>() {{
                put(3, 5000);
                put(4, 50000);
                put(5, 1500000);
                put(6, 2000000000);
            }});

}
