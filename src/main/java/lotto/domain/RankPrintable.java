package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public interface RankPrintable {
    RankPrintable NONE = new RankPrintable() {
        @Override
        public void makeRanksForPrint(Map<String, Integer> ranks) {
            return;
        }
    };

    void makeRanksForPrint(Map<String, Integer> ranks);
}

class First implements RankPrintable {
    @Override
    public void makeRanksForPrint(Map<String, Integer> ranks) {
        ranks.put("first", ranks.get("first") + 1);
    }
}

class Second implements RankPrintable {
    @Override
    public void makeRanksForPrint(Map<String, Integer> ranks) {
        ranks.put("second", ranks.get("second") + 1);
    }
}

class Third implements RankPrintable {
    @Override
    public void makeRanksForPrint(Map<String, Integer> ranks) {
        ranks.put("third", ranks.get("third") + 1);
    }
}

class Fourth implements RankPrintable {
    @Override
    public void makeRanksForPrint(Map<String, Integer> ranks) {
        ranks.put("fourth", ranks.get("fourth") + 1);
    }
}

