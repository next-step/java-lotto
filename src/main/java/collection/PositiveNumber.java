package collection;

public class PositiveNumber {
    private Integer value;
    public PositiveNumber(String input) {
        int i = Integer.parseInt(input);
        if(i < 0) {
            throw new RuntimeException();
        }

        this.value = i;
    }

    public Integer getValue() {
        return value;
    }
}
