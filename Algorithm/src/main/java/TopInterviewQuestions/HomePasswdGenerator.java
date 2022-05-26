package TopInterviewQuestions;



import java.util.Arrays;
import java.util.Random;

public class HomePasswdGenerator {
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generate(10,6)));
    }

    public static int[] generate(int bound, int bits) {
        int[] arr = new int[bits];
        for ( int i = 0; i< bits; i++ ) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
   

}

