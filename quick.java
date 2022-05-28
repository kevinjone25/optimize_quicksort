import java.util.Arrays;

class Main
{
    /**
     * 
     * @param arr the sub array to be sorted
     * @param left  the left index of the sub array
     * @param right the right index of the sub array
     *
     */
    public static void insertionSort_by_partition(int[] arr, int left, int right)
    {
        for (int i = left + 1; i <= right; i++)
        {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    /**
     * 
     * @param a     the array to be sorted
     * @param low  the left index of the sub array
     * @param high the right index of the sub array
     * @return
     */
    public static int HoarePartition(int[] a, int low, int high)
    {
        int pivot = a[low];
        int i = low;
        int j = high + 1;
        while (i < j)
        {
            do {
                i++;
            } while (i< high && a[i] <= pivot);
            do {
                j--;
            } while (j > low && a[j] >= pivot);
            if(i < j){
                swap(a, i, j);
            }
            
        }
        swap(a, low, j);
        return j;
    }

    /**
     * 
     * @param array the array to be sorted
     * @param i    the left index of the sub array
     * @param j   the right index of the sub array
     *
     */
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 
     * @param A the array to be sorted
     * @param low the left index of the sub array
     * @param high the right index of the sub array
     */
	public static void optimizedQuicksort(int[] A, int low, int high)
	{
		if (low < high)
		{
            if(high - low + 1 <= 3){
                insertionSort_by_partition(A, low, high);
                System.out.format("Use Insertion%s\n",Arrays.toString(A));
            }
            else{
                int pivot = HoarePartition(A, low, high);
                System.out.format("Use partition%s\n",Arrays.toString(A));
				optimizedQuicksort(A, low, pivot - 1);
				optimizedQuicksort(A, pivot + 1, high);
            }
			
        }
        else{
            return;
        }
}

/**
 * 
 * @param args
 */
public static void main(String[] args)
{
    int[] array_1 = {10, 4, 2, 8, 7, 3, 5, 9, 6, 1};
    int[] array_2 = {1, 6, 14, 13, 7, 2, 11, 10, 4, 9, 5, 8, 12, 3, 15};
    int[] array_3 = {8, 20, 16, 13, 15, 17, 12, 18, 19, 7, 10, 5, 4, 14, 2, 6, 1, 11, 9, 3};
        

    System.out.format("Before sorting is%s\n",Arrays.toString(array_1));
    optimizedQuicksort(array_1, 0,array_1.length-1);
    System.out.format("After sorting is%s\n\n",Arrays.toString(array_1));

    System.out.print("-----------------------------------------------------\n\n");

    System.out.format("After sorting is%s\n",Arrays.toString(array_2));
    optimizedQuicksort(array_2, 0,array_2.length-1);
    System.out.format("Before sorting is%s\n\n",Arrays.toString(array_2));

    System.out.print("-----------------------------------------------------\n\n");

    System.out.format("After sorting is%s\n",Arrays.toString(array_3));
    optimizedQuicksort(array_3, 0,array_3.length-1);
    System.out.format("Before sorting is%s\n",Arrays.toString(array_3));
    
}


}