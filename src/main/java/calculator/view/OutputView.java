package calculator.view;

public class OutputView
{
    private OutputView()
    {
        throw new IllegalArgumentException("utility class");
    }

    public static void print(double result)
    {
        System.out.println(result);
    }
}
