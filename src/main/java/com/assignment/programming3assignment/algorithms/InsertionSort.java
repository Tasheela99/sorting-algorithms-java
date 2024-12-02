// Source code is decompiled from a .class file using FernFlower decompiler.
package com.assignment.assignment.algorithms;

public class InsertionSort implements SortingAlgorithm {
   public InsertionSort() {
   }

   public void sort(double[] array) {
      for(int i = 1; i < array.length; ++i) {
         double key = array[i];

         int j;
         for(j = i - 1; j >= 0 && array[j] > key; --j) {
            array[j + 1] = array[j];
         }

         array[j + 1] = key;
      }

   }

   public String getName() {
      return "Insertion Sort";
   }
}

