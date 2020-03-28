package lotto.domain.statisitc;

import lotto.domain.item.Item;

import java.util.ArrayList;
import java.util.List;

public class MatchLotto {
    private final int matchCount;
    private final List<Item> matchItem;

    public MatchLotto(int matchCount) {
        this(matchCount, new ArrayList<>());
    }

    public MatchLotto(int matchCount, Item item) {
        this.matchCount = matchCount;
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        this.matchItem = items;
    }

    public MatchLotto(int matchCount, List<Item> item) {
        this.matchCount = matchCount;
        ArrayList<Item> items = new ArrayList<>();
        items.addAll(item);
        this.matchItem = items;
    }

    public MatchLotto addItem(Item other) {
        List<Item> items = new ArrayList<>();
        items.addAll(this.matchItem);
        items.add(other);

        return new MatchLotto(this.matchCount, items);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getItemsCount() {
        return this.matchItem.size();
    }

}
