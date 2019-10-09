import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("Test.txt"));
        bf.readLine();
        Integer[] arrToSearch = Arrays.stream(bf.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        bf.close();
        printResult(findNonIncreasing(arrToSearch));
    }

    private void printResult(int[] result) {
        System.out.println(result.length);
        StringBuilder sb = new StringBuilder();
        for (int elem :
                result) {
            sb.append(elem);
            sb.append(" ");
        }
        System.out.println(sb);
    }

    private int[] findNonIncreasing(Integer[] arrToSearch) {
        int[] dyn = new int[arrToSearch.length + 1];
        Arrays.fill(dyn, Integer.MIN_VALUE);
        dyn[0] = Integer.MAX_VALUE;
        int[] posOfTails = new int[arrToSearch.length + 1];
        int[] ancestors = new int[arrToSearch.length];


        for (int i = 0; i < arrToSearch.length; i++) {
            int j = getFirstLess(dyn, arrToSearch[i]);
            dyn[j] = arrToSearch[i];
            posOfTails[j] = i;
            ancestors[i] = posOfTails[j - 1];
        }

        int length = dyn.length - 1;
        for (; length >= 0; length--) {
            if (dyn[length] > Integer.MIN_VALUE) break;
        }
        int minIndex = posOfTails[length];

        int[] result = new int[length];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = minIndex + 1;
            minIndex = ancestors[minIndex];
        }
        return result;
    }

    private int getFirstLess(int[] arr, Integer value) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] >= value) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}