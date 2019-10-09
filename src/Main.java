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

        return new int[0];
    }
}