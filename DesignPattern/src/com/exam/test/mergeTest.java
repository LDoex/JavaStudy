package com.exam.test;

import java.util.ArrayList;

public class mergeTest {
    public mergeTest(){}

    public int traceBack(int[] arr, ArrayList path, int count, int res, int mergeLoc, int curLen){
        if(curLen==1){
            if(count<res) {
                res = count;
                System.out.println(path.toString() + res);
            }
            System.out.println(path.toString() + res);
            return res;
        }
        for(int i = 0; i<arr.length-1; i++){
            //找到第一位非零数
            if(arr[i]==-1) continue;
            int j = i+1;
            //找到毗邻i的第一位非零数
            while(j<arr.length && arr[j]==-1) j++;
            //如果j不存在，此时i位置是最后一位数，结束
            if(j==arr.length||count>=res)
                break;
            //如果j存在，进行合并操作，递归继续找
            else{
                int ai = arr[i];
                int aj = arr[j];
                arr[i] = arr[i]^arr[j];
                arr[j] = -1;
                int gap = Math.abs(ai-aj);
                path.add(i);
                res = traceBack(arr, path, count+gap, res, i, curLen-1);
                path.remove(path.size()-1);
                arr[i] = ai;
                arr[j] = aj;
            }
        }
        return res;
    }

    public int merge(int[] arr){
        ArrayList<Integer> path = new ArrayList<>();
        int t = traceBack(arr, path, 0, Integer.MAX_VALUE, 0, arr.length);
        return t;
    }


}
