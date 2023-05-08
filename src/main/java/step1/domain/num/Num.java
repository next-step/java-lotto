package step1.domain.num;

public class Num {

    private final int num;

    public Num(int num) {
        this.num = num;
    }

    public Num(String num) {
        this.num = stringParseInt(num);
    }

    public int getNum() {
        return num;
    }

    private int stringParseInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException npe) {
           throw new NumberFormatException("숫자를 입력해주세요.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Num num1 = (Num) o;
        return num == num1.num;
    }

    @Override
    public int hashCode() {
        return num;
    }
}
