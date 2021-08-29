package stringcalculator;

public class ResultView {

    private ResultView() {
        throw new AssertionError("ResultView 클래스는 객체를 생성할 수 없습니다.");
    }

    public static void printSum(WholeNumber number) {
        System.out.println("결과값은 " + number.value() + "입니다.");
    }
}
