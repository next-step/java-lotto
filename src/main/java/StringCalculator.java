public class StringCalculator {

    public int splitAndSum(String stringNumber) {
        StringNumbers stringNumbers = new StringNumbers(stringNumber);
        return stringNumbers.sumExecute();
    }
}
