package stringaccumulator;

public class StringAccumulator {

    public static void main(String[] args) {

        String source = "1,2:3";
        int sum = Expressions.of(source).sum();

        System.out.println(sum);
    }

}
