package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {8,7,9,0,6,2,3,4,5,1};
        new QuickSort().quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

        String[] lst = {"a","c","z","sd","om","asd","vz"};
        new QuickSort().quickSort(lst, 0, lst.length-1);
        System.out.println(Arrays.toString(lst));
    }

    // TODO
    public void quickSort(int[] arr, int left, int right) {
        if (right <= left) return;
        int base = arr[left];
        // 初始条件 i不能为left+1?!! 当数组长度为2时
        int i = left;
        int j = right;
        while (i<j) {
            // 双指针，从右边开始，确保j指向小于base的数
            for (;i<j && arr[j]>base;j--);
            for (;i<j && arr[i]<=base;i++);
            swap(arr, i, j);
        }
        swap(arr, left, j);
        quickSort(arr, left, j-1);
        quickSort(arr, j+1, right);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public <T extends Comparable> void quickSort(T[] arr, int left, int right) {
        if (right <= left) return;
        T base = arr[left];
        int i = left;
        int j = right;
        while (i<j) {
            for (;i<j && arr[j].compareTo(base)>0;j--);
            for (;i<j && arr[i].compareTo(base)<=0;i++);
            swap(arr, i, j);
        }
        swap(arr, left, j);
        quickSort(arr, left, j-1);
        quickSort(arr, j+1, right);
    }

    public <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
