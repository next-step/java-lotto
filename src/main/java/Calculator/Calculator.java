package Calculator;

public class Calculator {

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Calculator);
    }


    public int calculateText(String text) {
        if(isNullOrEmpty(text)) {
            return 0;
        }

        return sumTokens(getTokens(text));
    }

    private boolean isNullOrEmpty(String text){
        if(text == null) {
            return true;
        }
        if (text.isEmpty()) {
            return true;
        }

        return false;
    }

    private String[] getTokens(String text){
        return text.split(",");
    }

    private int sumTokens(String[] tokens){
        int result = 0;
        for(String token:tokens){
            result += Integer.parseInt(token);
        }
        return result;
    }

}
