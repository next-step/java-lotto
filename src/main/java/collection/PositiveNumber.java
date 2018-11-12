package collection;

public class PositiveNumber {
    private Long value;
    public PositiveNumber(String input) {
        Long i = Long.parseLong(input);
        if(i < 0) {
            throw new RuntimeException();
        }

        this.value = i;
    }

    public Long getValue() {
        return value;
    }
}
