package service.Arithmetic;

public class Plus implements Arithmetic{

    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}
