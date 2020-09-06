package utils;

import java.util.List;
import java.util.Objects;

public class Num {

    private int num;

    public Num(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public Num(String value) {
        try {
            this.num = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException(value + "cannot be parsed to number");
        }

        if (this.num < 0) {
            throw new RuntimeException(value + "is of negative value");
        }
    }

    public static int add(List<Num> numList) {
        return numList.stream()
                .mapToInt(Num::getNum)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Num num1 = (Num) o;
        return num == num1.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
