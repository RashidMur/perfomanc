import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Task4 {
    public static void main(String[] args) throws IOException {
        String coordinatesAndCentr = new String(Files.readAllBytes(Paths.get(args[0])));
        String[] strings = coordinatesAndCentr.split("\n");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(minMoves(nums));
    }

    public static int minMoves(int[] nums) {
        int srednee = 0;
        int summa = 0;
        for(int i = 0; i < nums.length ; i++) {
            summa += Math.abs(nums[i]);
            srednee = summa / nums.length;
        }
        int minMov = 0;
        for(int i = 0; i < nums.length ; i++) {
            minMov += Math.abs(srednee - Math.abs(nums[i]));
        }
        return minMov;
    }
}
