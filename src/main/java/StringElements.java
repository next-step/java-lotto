import java.util.ArrayList;
import java.util.List;

public class StringElements {
    private List<String> elements = new ArrayList<>();

    public void add(String element) {
        this.checkElement(element);
        this.elements.add(element);
    }

    public int sum() {
        return elements.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private void checkElement(String element) {
        if (element.contains("-")) {
            throw new IllegalArgumentException("the element must not have a negative value");
        }
    }
}
