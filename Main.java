import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Before: " + Arrays.toString(arr));
        
        mergeSort(arr, 0, arr.length - 1); // 传入左右index
        
        System.out.println("After:  " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) { // 通过比较left和right的index，来不断拆分，直到只有一个元素（只剩一个index，自己不能小于自己）
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid); // recursive 自己，拆分左边；
            // 递归过程当中拆分出「左边的左边、左边的右边」……
            mergeSort(arr, mid + 1, right); // recursive 自己，拆分右边；
            // 递归过程当中拆分出「右边的左边、右边的右边」……

            merge(arr, left, mid, right); // 拆分到最小之后，再开始下面的具体merge操作
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        // find sizes
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // init temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // fill temp arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // init pointer
        int i = 0, j = 0;
        int k = left;

        // merge temp arrays into arr
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // 当 i 或者 j 超出 n1 或者 n2 的长度，代表 左侧 或者 右侧 仅剩最后一个数没有被merge
        // 因此跳出上面的 while loop 至下面的 while loop 来 merge 最后一个

        // copy remaining elements of L[]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // copy remaining elements of R[]
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
