/** 
  Calculate Fibonacci number n
  3 implementations
  @precondition: n >= 1
  
  Use type "long" instead of "int", because rabbits.
 */

public class Fib {
    /** 
      @return the nth Fibonacci number
              by implementing the recurrence relation
     */

    //The largest n for which I feel like waiting is about 43 to 44.
    public static long fib_recurrence( int n) {
        if (n < 3) return 1; // Decision where to use the base case or the recursive case AND the solution to the base case
        return fib_recurrence(n-1) + fib_recurrence(n-2); //Recursive Case: 2 invocations of the recursive abstraction which are combined by addition. (Arguably no leftover processing)
    }

    /*
    Decision whether to use the instructions for the base case or the recursive case:
        (n < 3)
    Solution to the base case: 
        1
    Solution to the recursive case:
        Leftover Processing: N/A
        Invocation(s) of the recursive abstraction:
            fib_recurrence(n-1)
            fib_recurrence(n-2)
        Combination:
            +
    */

     /* These are class methods because each method will perform the same action no
     matter where it is called from, so it does not make sense for each instance
     to have its own unique fibonacci methods.
    */


    /** 
      @return the nth Fibonacci number
              calculated via the 8th-grade algorithm
     */
    public static long fib_grade8( int n) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return a;
    }
    /* Time complexity:
       Consider the size of the problem to be n.
       
       As the proxy for the time required, count the number of loops that must occur until the answer is returned.
       
       Then cost of the the 8th grade algorithm
       grows linearly
       as the size of the problem increases,
       because every time n increases by 1, the number of loops also increases by a constant factor, which is 1.
     */


    /** 
      @return the nth Fibonacci number
              calculated via Binet's formula.
              Type is double so that this exercise can
              ignore rounding issues.
     */
    public static double fib_Binet( int n) {
        double phi = Math.pow((1 + Math.sqrt(5)) / 2, n);
        double psi = Math.pow((1 - Math.sqrt(5)) / 2, n);
        return (phi - psi) / Math.sqrt(5);
    }
    /* Time complexity:
       Consider the size of the problem to be n.
       
       As the proxy for the time required, count the number of calculations that must be made to calculate the nth Fibonacci number.
       
       Then cost of the the binet algorithm
       is constant
       as the size of the problem increases,
       because the number of calculations does not depend on n.
     */
}
