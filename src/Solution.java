import java.util.Arrays;
import java.util.Random;

public class Solution {
    public int[] smallestK(int[] arr, int k) {
        Random ran = new Random();
        return Arrays.copyOf(arr, k);
    }
}
