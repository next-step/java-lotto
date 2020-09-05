package utils;

import java.util.List;

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

}
