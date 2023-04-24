public class StringCalculator {
    public int calculate(String input) {
        int result = 0;
        result = plus(input, result);
        result = minus(input, result);
        result = multiple(input, result);
        result = divide(input, result);

        return result;
    }

    private int divide(String input, int result) {
        if(input.contains("/")){
            String[] s = input.split("\\/");
            result += Integer.parseInt(s[0].trim());
            for (int i = 1; i < s.length ; i++) {
                result /= Integer.parseInt(s[i].trim());
            }
        }
        return result;
    }

    private int multiple(String input, int result) {
        if(input.contains("*")){
            String[] s = input.split("\\*");
            result += Integer.parseInt(s[0].trim());
            for (int i = 1; i < s.length ; i++) {
                result *= Integer.parseInt(s[i].trim());
            }
        }
        return result;
    }

    private int minus(String input, int result) {
        if(input.contains("-")){
            String[] s = input.split("\\-");
            result += Integer.parseInt(s[0].trim());
            for (int i = 1; i < s.length ; i++) {
                result -= Integer.parseInt(s[i].trim());
            }
        }
        return result;
    }

    private int plus(String input, int result) {
        if(input.contains("+")){
            String[] split = input.split("\\+");
            for(String c : split){
                result += Integer.parseInt(c.trim());
            }
        }
        return result;
    }
}
