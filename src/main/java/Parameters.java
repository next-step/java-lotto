public class Parameters {
    private final String[] value;

    public Parameters(String text) {
        validate(text);
        this.value = text.split(" ");
    }

    public String[] getValue() {
        return this.value;
    }

    public String indexOf(int index) {
        return this.value[index];
    }

    public int length() {
        return this.value.length;
    }

    private void validate(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("입력 값은 null이거나 빈 공백 문자일 수 없습니다 " + text);
        }
    }
}
