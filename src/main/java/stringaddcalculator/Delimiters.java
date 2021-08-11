package stringaddcalculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Delimiters {
    private final List<String> delimiters;

    /**
     * 단순 Arrays.asList() 를 통해 List 생성하는 경우 size 가 fix 되어 add 메서드를 사용할 수 없다.
     * 하여 List 변화가 필요할 시 LinkedList 를 사용하도록 하자.
     * ※ Arrays.asList: Returns 'a fixed-size list' backed by the specified array.
     * 참고 : https://stackoverflow.com/questions/2965747/why-do-i-get-an-unsupportedoperationexception-when-trying-to-remove-an-element-f
     */
    public Delimiters() {
        this.delimiters = new LinkedList<>(Arrays.asList(",", ":"));
    }

    public void addDelimiter(String customDelimiter) {
        this.delimiters.add(customDelimiter);
    }

    public List<String> getDelimiters() {
        return delimiters;
    }

    public String regex() {
        StringBuilder sb = new StringBuilder();
        delimiters.forEach((D) -> sb.append(D).append("|"));
        return sb.substring(0, sb.length() - 1);
    }

}
