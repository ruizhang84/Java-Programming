/*
  Get all prime number between 2 and 100.
  brute foce and sieve of Eratosthenes.
*/
public class EroSieve{
    public static void main(String[] args){
        int i,j,k;                         //method 1 - brute force
        for (i = 2; i<101; i++){
            for (j = 2; j<i+1; j++){
                if (i%j == 0) break;
            }
            if (i == j)
                System.out.println("The primer number is :" + i);
        }

        boolean[] array = new boolean[100];     //method 2 - sieve of Eratosthenes
        for (i= 0; i<100; i++){
            array[i] =  true;
        }
        i = 2;                                 
        while (i*i <＝ 100){
            for (k = 2, j = i*2; j< 100; j = k*i, k++){
                array[j] = false;
            }
            do {
                i++;
            }
            while (i*i < 100 && !array[i] );
        }
    
        for (i = 2; i<100; i++){
            if (array[i]) System.out.println("The primer number is :" + i);
        }
        
    }

}
