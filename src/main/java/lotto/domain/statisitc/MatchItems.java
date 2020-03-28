package lotto.domain.statisitc;

import lotto.domain.item.Item;

import java.util.ArrayList;
import java.util.List;

public class MatchItems {
    private List<MatchLotto> items;

    public MatchItems(MatchLotto other) {
        List<MatchLotto> items = new ArrayList<>();
        items.add(other);
        this.items = items;
    }

    public MatchItems(List<MatchLotto> other) {
        List<MatchLotto> items = new ArrayList<>();
        items.addAll(other);
        this.items = items;
    }

    private int findCountMatchItemIndex(int count) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getMatchCount() == count) {
                return i;
            }
        }
        return -1;
    }

    public MatchItems addMatchItem(int machCount, Item other) {
        int index = findCountMatchItemIndex(machCount);

        if (index == -1) {
            items.add(new MatchLotto(machCount, other));
            return new MatchItems(items);
        }

        items.set(index, items.get(index).addItem(other));
        return new MatchItems(items);
    }

    public int size() {
        return items.size();
    }

    public List<MatchLotto> getItems() {
        return items;
    }
}
