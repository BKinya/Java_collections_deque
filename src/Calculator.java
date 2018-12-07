import java.util.ArrayDeque;
import java.util.Deque;

/**
 * calculator class shows implementation of deques of java collection framework using
 * ArrayDeque
 */

public class Calculator {


    /**
     * do calculation as per the input string
     * @param number_input
     * return int ; the result
     */
    public int  doCalculation(String number_input){

        Deque<String> stack = new ArrayDeque<>();

        String [] tokens = number_input.split(" ");


        //add the elements in the string to the stack
        for (String token: tokens   ){
            stack.offer(token);

        }


        /**
         * if the stack has more than one element pop the first two
         * do the arithmetic operation as per the string
         * push the result back to the stack until all calculation is complete
         * return the result
         */

        while (stack.size()>1){
            int first_number = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int second_number = Integer.parseInt(stack.pop());
            int result = 0;

            switch (operator){
                case "+":
                    result = first_number + second_number;
                    break;
                case "-":
                    result = first_number - second_number;
                    break;
            }

            stack.push(String.valueOf(result));


        }

        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args){
        Calculator calculator = new Calculator();

        int res = calculator.doCalculation("2 + 7 - 3 + 6 - 1");
        System.out.println(res);

    }
}
