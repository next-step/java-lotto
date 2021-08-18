package StringCalculator;

public class ResultView {

    static void printSum(WholeNumber number) {
        StringBuilder sb = new StringBuilder();
        sb.append("결과값은 ");
        sb.append(number.getValue());
        sb.append("입니다.");
        System.out.println(sb);
    }
}
