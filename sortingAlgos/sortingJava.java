package sortingAlgos;

public class sortingJava {
    public static void main(String[] args) {
        int[] tester = { 4, 2, 55, 6, 2, 1 };
        // insert tests here

        /**
         * insertionSort(tester); for (int i : tester) { System.out.println(i + " "); }
         * 
         * selectionSort((tester)); for (int i : tester) { System.out.println(i + " ");
         * }
         **/
        mergeSort(tester, 0, tester.length);
        for (int i : tester) {
            System.out.println(i + " ");
        }
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

    // Still needs to be fixed
    public static int[] merge(int[] array, int startIdx, int midIdx, int endIdx) {
        int len1 = midIdx - startIdx + 1;
        int len2 = endIdx - midIdx;

        int[] lowHalf = new int[len1];
        int[] highHalf = new int[len2];

        for (int i = 0; i < len1; i++) {
            lowHalf[i] = array[startIdx + i];
        }

        for (int i = 0; i < len2; i++) {
            highHalf[i] = array[midIdx + 1 + i];
        }

        int k = startIdx;
        int j = 0;
        int i = 0;

        while (i < lowHalf.length && j < highHalf.length) {
            if (lowHalf[i] < highHalf[j]) {
                array[k] = lowHalf[i];
                i++;
            } else {
                array[k] = highHalf[j];
                j++;
            }
            k++;
        }

        // once the first while loop has exited, there may be "leftovers" in one of the
        // subsequences - this subsequence has already been sorted.

        while (i < lowHalf.length) {
            array[k] = lowHalf[i];
            k++;
            i++;
        }

        while (j < highHalf.length) {
            array[k] = highHalf[j];
            k++;
            j++;
        }

        return array;
    }

    public static int[] mergeSort(int[] array, int startIdx, int endIdx) {
        int midIdx = (int) Math.floor((startIdx + endIdx) / 2);

        if (startIdx < endIdx) {
            mergeSort(array, startIdx, midIdx);
            mergeSort(array, midIdx + 1, endIdx);
            merge(array, startIdx, midIdx, endIdx);
        }

        return array;
    }
}
