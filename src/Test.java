public class Test {
    public static void main(String[] args) {
        int [] num = {2,34,6,6,2,3,4,5,1,57};

        longestIncreasingSequence(num);
    }

    public static void longestIncreasingSequence(int[] arr) {
        int n = arr.length;
        int[] LIS = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            LIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                }
            }
            if (LIS[i] > max) {
                max = LIS[i];
            }
        }

        System.out.println("Довжина найбільшої зростаючої послідовності: " + max);
    }
}
