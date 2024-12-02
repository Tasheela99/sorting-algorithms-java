// Source code is decompiled from a .class file using FernFlower decompiler.
package com.assignment.assignment.algorithms;

public class MergeSort implements SortingAlgorithm {
   public MergeSort() {
   }

   public void sort(double[] array) {
      this.mergeSort(array, 0, array.length - 1);
   }

   public String getName() {
      return "Merge Sort";
   }

   private void mergeSort(double[] array, int left, int right) {
      if (left < right) {
         int middle = (left + right) / 2;
         this.mergeSort(array, left, middle);
         this.mergeSort(array, middle + 1, right);
         this.merge(array, left, middle, right);
      }

   }

   private void merge(double[] array, int left, int middle, int right) {
      int n1 = middle - left + 1;
      int n2 = right - middle;
      double[] leftArray = new double[n1];
      double[] rightArray = new double[n2];
      System.arraycopy(array, left, leftArray, 0, n1);
      System.arraycopy(array, middle + 1, rightArray, 0, n2);
      int i = 0;
      int j = 0;

      int k;
      for(k = left; i < n1 && j < n2; ++k) {
         if (leftArray[i] <= rightArray[j]) {
            array[k] = leftArray[i];
            ++i;
         } else {
            array[k] = rightArray[j];
            ++j;
         }
      }

      while(i < n1) {
         array[k] = leftArray[i];
         ++i;
         ++k;
      }

      while(j < n2) {
         array[k] = rightArray[j];
         ++j;
         ++k;
      }

   }
}
