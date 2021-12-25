package sort;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length-1, k);
    }

    // TODO 递归浪费空间，可使用循环
    public int quickSort(int[] arr, int left, int right, int target) {
        if (left>right) return -1;
        int base = arr[left];
        int i = left;
        int j = right;
        while (i<j) {
            for (;i<j && arr[j]>base; j--);
            for (;i<j && arr[i]<=base; i++);
            swap(arr, i, j);
        }
        swap(arr, left, j);
        if (arr.length-j == target) return arr[j];
        if (arr.length-j>target) return quickSort(arr, j+1, right, target);
        return quickSort(arr, left, j-1, target);
    }

    public int findKthLargest2(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) ;
            while (a[--j] > a[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // TODO 使用堆排序，最小堆
}
