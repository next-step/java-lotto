package lotto.domain.statisitc;

import lotto.domain.item.Item;
import lotto.domain.item.MatchLotto;

import java.util.ArrayList;
import java.util.List;

public class MatchLottoStatistic {
    private static final int LOTTO_MATCH_NUMBER_COUNT3 = 3;
    private static final int LOTTO_MATCH_NUMBER_COUNT4 = 4;
    private static final int LOTTO_MATCH_NUMBER_COUNT5 = 5;
    private static final int LOTTO_MATCH_NUMBER_COUNT6 = 6;

    private List<MatchLotto> matchLottos;

    public MatchLottoStatistic(List<Item> lottos, List<Integer> luckNumber) {
        List<MatchLotto> items = new ArrayList<>();

        this.matchLottos = items;
    }

    public MatchLottoStatistic(MatchLotto other) {
        List<MatchLotto> items = new ArrayList<>();
        items.add(other);
        this.matchLottos = items;
    }

//    public MatchItemsStatistic(List<MatchLotto> other) {
//        List<MatchLotto> items = new ArrayList<>();
//        items.addAll(other);
//        this.items = items;
//    }

    private int findCountMatchItemIndex(int count) {
        for (int i = 0; i < matchLottos.size(); i++) {
            if (matchLottos.get(i).isMatchCountSame(count)) {
                return i;
            }
        }
        return -1;
    }

    public void addMatchItem(int machCount, Item other) {
        int index = findCountMatchItemIndex(machCount);

        if (index == -1) {
            matchLottos.add(new MatchLotto(machCount, other));
            return;
        }

        matchLottos.set(index, matchLottos.get(index).addItem(other));
    }

    public int size() {
        return matchLottos.size();
    }

    public List<MatchLotto> getMatchLottos() {
        return matchLottos;
    }
}
