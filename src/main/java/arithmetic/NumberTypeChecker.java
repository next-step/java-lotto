package arithmetic;

public class NumberTypeChecker {

    private NumberTypeChecker() { //인스턴스화 방지
    }

    public static boolean isEvenValue(int input) {
        return input % 2 == 0;
    }
}
