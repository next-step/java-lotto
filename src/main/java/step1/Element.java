package step1;

public class Element {
    int value;

    public Element(int value) {
        this.value = value;
    }

    public static Element from(int value) {
        if (value < 0) {
            throw new RuntimeException("음수는 아니되옵니다.");
        }
        return new Element(value);
    }

    public static Element from(String inputString) {
        return Element.from(Integer.parseInt(inputString));
    }
}
