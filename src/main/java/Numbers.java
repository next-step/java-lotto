import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Integer> numberList = new ArrayList<>();

    public boolean isNumber(String element) {
        return element.matches("[+-]?\\d+");
    }

    public void addNumber(String element) {
        int number = Integer.parseInt(element);
        numberList.add(number);
    }

    public final Integer getNumberByIndex(int index) {
        return numberList.get(index);
    }

    public int getLengthOfNumbers() {
        return numberList.size();
    }
}
