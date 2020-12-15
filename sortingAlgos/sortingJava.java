public class sortingJava {
    public static void main(String[] args) {
        int[] tester = { 4, 2, 55, 6, 2, 1 };
        // insert tests here
        // insertionSort(tester);
        // for (int i : tester) {
        // System.out.println(i + " ");
        // }
    }

    /**
     * Go through each element from left to right in the array and place it where it
     * fits.
     * 
     * @param array array to be sorted
     * @return sorted array
     */
    public static int[] insertionSort(int[] array) {
        int j;
        if (array.length <= 1) {
            return array;
        }
        for (j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = key;
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIdx = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = temp;
        }

        return array;
    }
}
