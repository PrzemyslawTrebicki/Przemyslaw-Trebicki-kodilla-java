package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;
public class OddNumbersExterminator {
    public List<Integer> exterminate(List<Integer> numbers){
        ArrayList<Integer>oddNumbersList=new ArrayList<>();
        for(int num : numbers){
            if(num%2==0){
                oddNumbersList.add(num);
            }
        }
        return oddNumbersList;
    }
}
