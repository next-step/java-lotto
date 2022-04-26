package stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Items {
    public static final int LOWER_BOUND = 2;
    public static final int FIRST_OPERAND_INDEX = 0;
    public static final int OPERATOR_INDEX = 1;
    public static final int SECOND_OPERAND_INDEX = 2;
    private final List<String> items;

    Items(List<String> items) {
        validate(items);
        this.items = new ArrayList<>(items);
    }

    private void validate(List<String> items) {
        Objects.requireNonNull(items, "Items 는 null일 수 없습니다.");
        if (items.size() < LOWER_BOUND) {
            throw new IllegalArgumentException("Items 는 2개 이상의 Item 으로 이루어져야 합니다.");
        }
    }

    public int size() {
        return items.size();
    }

    public int getFirstOperand() {
        return Integer.parseInt(items.get(FIRST_OPERAND_INDEX));
    }

    public String getOperator() {
        return items.get(OPERATOR_INDEX);
    }

    public int getSecondOperand() {
        return Integer.parseInt(items.get(SECOND_OPERAND_INDEX));
    }

    public static Items of(int baseNumber, Items items) {
        validate(items);

        List<String> newItems = new ArrayList<>();
        newItems.add(String.valueOf(baseNumber));
        for (int i = 3; i < items.size(); i++) {
            newItems.add(items.items.get(i));
        }
        return new Items(newItems);
    }

    private static void validate(Items items) {
        Objects.requireNonNull(items, "Items 는 null일 수 없습니다.");
    }
}
