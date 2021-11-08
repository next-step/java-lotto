package step1;

import java.util.ArrayList;
import java.util.List;

public class Items {

    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public int size() {
        return items.size();
    }
}
