package letterCalculator;

public class Calulator {

    private String inputString;
    public Calulator(String inputString) {
        this.inputString = inputString;
    }
    public Calulator() {
    }
    public void showString() {
        System.out.println(inputString);
//        for (int i= 0; i<inputString.length;i++)
//        {
//        System.out.println(inputString);
//        }
    }

    public int CalulatorNonZero(String inputString) {
        if(inputString.equals(null)||inputString.isBlank() )
        {
            return 0;
        }
        return 0;
    }

    public boolean returnZero(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            System.out.println("["+inputString+"]");
            return true;
        }
        return false;
    }


    public int calcSum() {
        return  0;
    }
    public int calculator() {
        String[] numbers;
        if(returnZero(this.inputString))
        {
            return 0;
        }

        numbers = getSplit();
        if(!negativeInputNumberCheck(numbers)) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        };

//        addNumbers(numbers);
        return addNumbers(numbers);
    }

    private int addNumbers(String[] numbers) {
        int result;
        result = Integer.parseInt(numbers[0]);
        for(int i = 1; i < numbers.length; i++) {
            result = result + Integer.parseInt(numbers[i]);
        }

        return result;
    }

    private String[] getSplit() {
        String returnValue[]=inputString.split(",|:");
        return returnValue;
    }

    private boolean negativeInputNumberCheck(String[] inputString){
        for(String s : inputString) {
            if(Integer.parseInt(s) < 0) {
                return false;
            }
        }
        return true;
    }
}
