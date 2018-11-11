package collection;

public class IntegerWrapper {
    private Integer value;

    public IntegerWrapper(String s) {
        // 양의 정수가 아니면 런타임 에러 발생
        if (!isPositiveInteger(s)) {
            throw new RuntimeException("양의 정수가 아닌 값은 입력될 수 없습니다.");
        }
        this.value = Integer.parseInt(s);
    }

    /**
     * 양의 정수인가?
     *
     * @param s
     * @return
     */
    private boolean isPositiveInteger(String s) {
        return s != null && s.charAt(0) != '-' && !s.matches("\\D");
    }

    public Integer getValue() {
        return value;
    }
}
