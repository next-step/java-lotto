package collection;

public class IntegerWrapper {
    private Integer value;
    public IntegerWrapper(String input) {
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
