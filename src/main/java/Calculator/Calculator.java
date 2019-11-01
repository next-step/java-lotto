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


        return 1;
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
}
