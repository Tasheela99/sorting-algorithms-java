// Source code is decompiled from a .class file using FernFlower decompiler.
package com.assignment.assignment.algorithms;

public class QuickSort implements SortingAlgorithm {
   public QuickSort() {
   }

   public void sort(double[] array) {
      this.quickSort(array, 0, array.length - 1);
   }

   public String getName() {
      return "Quick Sort";
   }

   private void quickSort(double[] array, int low, int high) {
      while(low < high) {
         int pivot = this.medianOfThree(array, low, high);
         pivot = this.partition(array, low, high, pivot);
         if (pivot - low < high - pivot) {
            this.quickSort(array, low, pivot - 1);
            low = pivot + 1;
         } else {
            this.quickSort(array, pivot + 1, high);
            high = pivot - 1;
         }
      }

   }

   private int medianOfThree(double[] array, int low, int high) {
      int mid = low + (high - low) / 2;
      if (array[low] > array[mid]) {
         this.swap(array, low, mid);
      }

      if (array[mid] > array[high]) {
         this.swap(array, mid, high);
      }

      if (array[low] > array[mid]) {
         this.swap(array, low, mid);
      }

      this.swap(array, mid, high - 1);
      return high - 1;
   }

   private void swap(double[] array, int i, int j) {
      double temp = array[i];
      array[i] = array[j];
      array[j] = temp;
   }

   private int partition(double[] array, int low, int high, int pivotIndex) {
      double pivotValue = array[pivotIndex];
      this.swap(array, pivotIndex, high);
      int storeIndex = low;

      for(int i = low; i < high; ++i) {
         if (array[i] < pivotValue) {
            this.swap(array, i, storeIndex);
            ++storeIndex;
         }
      }

      this.swap(array, storeIndex, high);
      return storeIndex;
   }
}
