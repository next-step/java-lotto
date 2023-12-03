package operation;

public class Operater {
    public static int calculate(String inPut) {
        String[] split = inPut.trim().split(" ");
        int result = Integer.parseInt(split[0]);
        for (int i = 1; i < split.length; i += 2) {
            String operator = split[i];
            int number = Integer.parseInt(split[i + 1]);
            result = Operations.calculateRightNow(result,number,operator);
        }
        return result;
    }
}
