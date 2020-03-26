import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String inputData) {
        if (inputData == null || inputData.isEmpty()) {
            return 0;
        }
        int result = 0;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputData);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] splitInputData = m.group(2).split(customDelimiter);

            for (int i = 0; i < splitInputData.length; i++) {
                if(Integer.parseInt(splitInputData[i]) <0){
                    throw new RuntimeException();
                }

                result = result + Integer.parseInt(splitInputData[i]);
            }
        }else{

            String[] splitInputData = inputData.split(",|:");

            for (int i = 0; i < splitInputData.length; i++) {
                if(Integer.parseInt(splitInputData[i]) <0){
                    throw new RuntimeException();
                }
                result = result + Integer.parseInt(splitInputData[i]);
            }
        }

        return result;
    }
}
