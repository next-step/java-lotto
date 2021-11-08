package step1;

import java.util.Objects;

public class Item {

    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "입력 값이 숫자가 아닙니다.";
    private static final String NULL_OR_EMPTY_EXCEPTION_MESSAGE = "입력 값은 빈값일 수 없습니다.";

    private final int item;

    private Item(int item) {
        this.item = item;
    }

    public static Item from(String itemStr) {
        if(itemStr == null || itemStr.isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_EXCEPTION_MESSAGE);
        }
        if(!itemStr.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }
        return new Item(Integer.parseInt(itemStr));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item1 = (Item) o;
        return item == item1.item;
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }
}
