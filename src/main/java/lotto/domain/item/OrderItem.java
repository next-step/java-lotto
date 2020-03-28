package lotto.domain.item;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
    private final List<Item> orderItems;

    public OrderItem() {
        orderItems = new ArrayList<>();
    }

    public OrderItem(List<Item> orderItems) {
        List<Item> items = new ArrayList<>();
        items.addAll(orderItems);
        this.orderItems = items;
    }

    public OrderItem addItem(Item other) {
        List<Item> items = new ArrayList<>();
        items.addAll(orderItems);
        items.add(other);
        return new OrderItem(items);
    }

    public int size() {
        return this.orderItems.size();
    }
}
