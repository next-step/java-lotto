package step2;

import java.util.Objects;

public class Num {

    private int value;

    private Num(int value) {
        this.value = value;
    }

    public static Num of(int value){
        return new Num(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Num num = (Num) o;
        return value == num.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
