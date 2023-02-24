import java.util.Arrays;
import java.util.Random;

public class Solution {
    public int[] smallestK(int[] arr, int k) {
        Random ran = new Random();
        quickSort2Ways(arr, 0, arr.length - 1, k, ran);
        return Arrays.copyOf(arr, k);
    }

    public void quickSort2Ways(int[] arr, int l, int r, int k, Random ran) {
        if (l > r) return;
        int par = partition(arr, l, r, ran);
        if (par > k) quickSort2Ways(arr, l, par - 1, k, ran);
        else if (par < k) quickSort2Ways(arr, par + 1, r, r - k - par - 1, ran);
    }

    private int partition(int[] arr, int l, int r, Random ran) {
        int random = l + ran.nextInt(r - l + 1);
        swap(arr, l, random);
        int i = l + 1, j = r;
        while (true) {
            while (i <= j && arr[i] < arr[l]) i++;
            while (j >= i && arr[j] > arr[l]) j--;
            if (i >= j) break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int l, int random) {
        int t = arr[l];
        arr[l] = arr[random];
        arr[random] = t;
    }
}
