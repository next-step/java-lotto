package step1;

public class Element {
    int value;

    public Element() {
    }

    public Element(int value) {
        this.value = value;
    }

    public static Element from(int value) {
        return new Element(value);
    }

    public static Element from(String testValue) {
        return Element.from(Integer.parseInt(testValue));
    }
}
