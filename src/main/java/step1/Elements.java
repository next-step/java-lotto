package step1;

import java.util.ArrayList;
import java.util.List;

public class Elements {
    private List<Element> elements;

    private Elements(List<Element> inputString) {
        this.elements = new ArrayList<>(inputString);
    }

    public static Elements from(List<Element> testElements) {
        return new Elements(testElements);
    }
}
