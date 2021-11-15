package step1.domain;

public class Number {

    private Integer num;

    public Number(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Number number = (Number) o;

        return num != null ? num.equals(number.num) : number.num == null;
    }

    @Override
    public int hashCode() {
        return num != null ? num.hashCode() : 0;
    }
}
