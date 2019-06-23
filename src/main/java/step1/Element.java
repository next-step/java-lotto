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
        if (!inputString.matches("[0-9]\\d*")) {
            throw new RuntimeException("0 이상의 자연수만 가능합니다.");
        }
        return Element.from(Integer.parseInt(inputString));
    }
}
