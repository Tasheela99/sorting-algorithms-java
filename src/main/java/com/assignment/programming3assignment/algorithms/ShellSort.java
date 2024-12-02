package com.assignment.programming3assignment.algorithms;// Source code is decompiled from a .class file using FernFlower decompiler.

public class ShellSort implements SortingAlgorithm {
   public ShellSort() {
   }

   public void sort(double[] array) {
      int n = array.length;

      for(int gap = n / 2; gap > 0; gap /= 2) {
         for(int i = gap; i < n; ++i) {
            double temp = array[i];

            int j;
            for(j = i; j >= gap && array[j - gap] > temp; j -= gap) {
               array[j] = array[j - gap];
            }

            array[j] = temp;
         }
      }

   }

   public String getName() {
      return "Shell Sort";
   }
}
