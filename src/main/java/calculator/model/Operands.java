package calculator.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Operands {

   private static final int CALCULATE_SIZE = 2;
   private final Deque<Operand> operands;


   public Operands() {
      this.operands = new ArrayDeque<>();
   }

   public void add(Operand operand){
      if(this.operands.size() > CALCULATE_SIZE){
         throw new IllegalArgumentException("invalid operator number");
      }
      this.operands.add(operand);
   }

   public boolean isCalculable(){
      return this.operands.size() == CALCULATE_SIZE;
   }

   public Operand getOperand(){
      return this.operands.pollFirst();
   }
}
