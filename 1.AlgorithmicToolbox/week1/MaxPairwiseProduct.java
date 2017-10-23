import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static int getMaxPairwiseProduct(int[] numbers) {
        int result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (numbers[i] * numbers[j] > result) {
                    result = numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }

    static long getMaxPairwiseProductBetter(int[] numbers) {
        long max1 = 0;
        long max2 = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= max1) {
                max2 = max1;
                max1 = numbers[i];
            } else if (numbers[i] > max2) {
                max2 = numbers[i];
            }
        }
        return max1 * max2;
    }

    public static void main(String[] args) {
        // Random rand = new Random();
        // while (true) {
        //     int n = rand.nextInt(10);
        //     int[] arr = new int[n];
        //     for (int i = 0; i < n; i++) {
        //         arr[i] = rand.nextInt(10);
        //         System.out.print(arr[i] + " ");
        //     }
        //     System.out.println();

        //     long res1 = getMaxPairwiseProductBetter(arr);
        //     long res2 = getMaxPairwiseProduct(arr);

        //     if (res1 != res2) {
        //         System.out.println("Wrong ans " + res1 + " " + res2);
        //     } else {
        //         System.out.println("OK");
        //     }

        // }

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductBetter(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}