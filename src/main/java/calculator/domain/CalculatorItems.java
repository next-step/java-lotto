package calculator.domain;

public class CalculatorItems {

    private static final String DELIMITER = " ";

    private final String[] items;
    private int position;

    public CalculatorItems(String input) {
        validate(input);
        this.items = input.split(DELIMITER);
    }

    private void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력한 내용이 없습니다.");
        }
    }

    public boolean hasNext() {
        return position < items.length;
    }

    public int nextAsInt() {
        throwIfHasNotNext();
        try {
            return Integer.parseInt(items[position++]);
        } catch (NumberFormatException e) {
            throw new IllegalStateException(String.format("현재 위치의 아이템은 int로 가져올 수 없습니다.(%s)",
                    items[--position]));
        }
    }

    public String nextAsString() {
        throwIfHasNotNext();
        return items[position++];
    }

    private void throwIfHasNotNext() {
        if (!hasNext()) {
            throw new IllegalStateException("다음 입력값이 존재하지 않습니다.");
        }
    }
}