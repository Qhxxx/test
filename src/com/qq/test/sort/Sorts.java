package com.qq.test.sort;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author qq
 * @Package com.qq.test.sort
 * @date 2021/4/3 22:52
 */
public class Sorts {

    public static void main(String[] args) {

        //快排
        int[] arr = {5, 1, 6, 2, 5};
        quickSort(0, arr.length - 1, arr);
        System.out.println("快排" + Arrays.toString(arr));

        //归并
        arr = new int[]{5, 2, 3, 1, 4};
        int[] temp = new int[arr.length];
        mergeSort(0, arr.length - 1, arr, temp);

        System.out.println("归并" + Arrays.toString(arr));
        arr = new int[]{7,6,5,11,5,12,3,0,1};
        heapSort(arr);
        System.out.println("堆排" + Arrays.toString(arr));


    }

    /**
     * 堆排
     * @param arr
     */
    public static void heapSort(int[] arr) {
        //建大根堆 升序
        for(int i = arr.length/2-1; i >= 0; --i){//length/2-1为最后一个非叶子节点
            adjustHeap(i,arr,arr.length);
        }
        for(int i = arr.length -1; i >0; --i){
            int temp = arr[i];//交换第一个和最后一个的位置
            arr[i]=arr[0];
            arr[0]=temp;
            adjustHeap(0,arr,i);
        }
    }

    public static void adjustHeap(int index, int[] arr, int length) {
        int temp = arr[index];

        for (int i = index * 2 + 1; i < length; i = i * 2 + 1) {
            if(i + 1 < length && arr[i+1]>arr[i]){//index*2+1左节点  比较左节点大还是右节点大
                i++;
            }
            if(arr[i] > temp){
                arr[index] = arr[i];
                index = i;//往下遍历
            }else{
                break;
            }
        }
        arr[index] = temp;
    }

    /**
     * 快排
     *
     * @param left
     * @param right
     * @param arr
     */
    public static void quickSort(int left, int right, int[] arr) {
        if (left >= right) return;
        int temp = arr[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && arr[r] >= temp) r--;
            arr[l] = arr[r];
            while (l < r && arr[l] <= temp) ++l;
            arr[r] = arr[l];
        }
        arr[l] = temp;
        quickSort(left, l - 1, arr);
        quickSort(l + 1, right, arr);
    }

    /**
     * 归并排序
     *
     * @param left
     * @param right
     * @param arr
     * @param temp
     */
    public static void mergeSort(int left, int right, int[] arr, int[] temp) {
        if (left >= right) return;
        int mid = left + ((right - left) >> 1);

        mergeSort(left, mid, arr, temp);
        mergeSort(mid + 1, right, arr, temp);
        if (arr[mid + 1] > arr[mid]) return;
        int l = left;
        int index = left;
        int r = mid + 1;
        while (index <= right ) {
            if (l == (mid + 1)) temp[index++] = arr[r++];
            else if (r == (right + 1)) temp[index++] = arr[l++];
            else if (arr[l] < arr[r]) temp[index++] = arr[l++];
            else temp[index++] = arr[r++];

        }
        //System.out.println(index);
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}
