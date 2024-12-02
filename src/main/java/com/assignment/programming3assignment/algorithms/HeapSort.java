package com.assignment.programming3assignment.algorithms;// Source code is decompiled from a .class file using FernFlower decompiler.

public class HeapSort implements SortingAlgorithm {
   public HeapSort() {
   }

   public void sort(double[] array) {
      int n = array.length;

      int i;
      for(i = n / 2 - 1; i >= 0; --i) {
         this.heapify(array, n, i);
      }

      for(i = n - 1; i > 0; --i) {
         double temp = array[0];
         array[0] = array[i];
         array[i] = temp;
         this.heapify(array, i, 0);
      }

   }

   public String getName() {
      return "Heap Sort";
   }

   private void heapify(double[] array, int n, int i) {
      int largest = i;
      int left = 2 * i + 1;
      int right = 2 * i + 2;
      if (left < n && array[left] > array[i]) {
         largest = left;
      }

      if (right < n && array[right] > array[largest]) {
         largest = right;
      }

      if (largest != i) {
         double temp = array[i];
         array[i] = array[largest];
         array[largest] = temp;
         this.heapify(array, n, largest);
      }

   }
}
