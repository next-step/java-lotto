package StringAdder;

import java.util.Objects;

public class Num {

    int value;

    public Num(int i) {
        this.value = i;
    }

    public Num add(Num other) {
        return new Num(this.value + other.value);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Num num = (Num) object;

        return value == num.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
