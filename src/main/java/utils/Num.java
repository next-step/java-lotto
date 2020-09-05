package utils;

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

}
