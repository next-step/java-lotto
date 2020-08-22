package lotto.utils;

public class StringUtils {

    private String value;

    public StringUtils(String value) {
        this.value = value;
    }

    public int toInt() {
        return Integer.parseInt(this.value);
    }

    public String[] split(String delimiter) {
        return this.value.split(delimiter);
    }

}
