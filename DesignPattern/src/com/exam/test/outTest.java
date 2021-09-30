package com.exam.test;

import java.util.*;

public class outTest {

    public static void main(String[] args) {
        int maxSize = 50;
        int maxNum = 100;
        int testTime = 100000;
//        for(int i=0; i<testTime; ++i){
//            int[] t = instanceGen(maxSize, maxNum);
//            int[] t2 = Arrays.copyOf(t, t.length);
//            int[] out1 = fun1(t);
//            int[] out2 = fun2(t2);
//            if(!isEqual(out1, out2) && (t2[out1[1]]-t2[out1[0]])!=(t2[out2[1]]-t2[out2[0]])){
//                System.out.println(Arrays.toString(t2));
//                System.out.println(Arrays.toString(out1)+(t2[out1[1]]-t2[out1[0]]));
//                System.out.println(Arrays.toString(out2)+(t2[out2[1]]-t2[out2[0]]));
//            }
//        }
        int[] t = {2, 8, 1, 5, 4, 3, 6};
        System.out.println(Arrays.toString(fun2(t)));
    }

    //fun1
    public static int[] fun1(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; ++i){
            map.put(arr[i], i);
        }
        Arrays.sort(arr);
        int end = 0;
        int fir = 0;
        int maxC = 0;
        int[] res = new int[2];
        for(int j=0; j<arr.length; ++j){
            int cur = 0;
            for(int k=arr.length-1; k>j; --k){
                if(map.get(arr[k])>map.get(arr[j])){
                    cur = arr[k]-arr[j];
                    fir = map.get(arr[j]);
                    end = map.get(arr[k]);
                    break;
                }
            }
            if(cur>maxC){
                res[0] = fir;
                res[1] = end;
                maxC = cur;
            }
        }
        return res;
    }

    //fun2
    public static int[] fun2(int[] arr){
        int[] res = new int[2];
        int cost = Integer.MAX_VALUE, profit = 0;
        int fir = 0;
        int end = 0;
        for(int i=0; i<arr.length; ++i){
            if(arr[i]<cost){
                cost = arr[i];
                fir = i;
            }
            if(profit<arr[i]-cost){
                profit = arr[i]-cost;
                end = i;
            }
            if(fir<end){
                res[0] = fir;
                res[1] = end;
            }
        }
        return res;
    }

    //随机数组生成器
    public static int[] instanceGen(int maxSize, int maxNum){
        int size = (int)(Math.random()*(maxSize+1));
        int[] res = new int[size];
        HashSet<Integer> set = new HashSet<>();
        //循环填充数组
        for(int i=0; i<size; ++i){
            int num = (int)(Math.random()*(maxNum+1));
            //生成不重复的数组
            while(set.add(num)==false){
                num = (int)(Math.random()*(maxNum+1));
            }
            res[i] = num;
        }
        return res;
    }

    //结果比较器
    public static boolean isEqual(int[] out1, int[] out2){
        if((out1==null&&out2!=null)||(out1!=null&&out2==null)){
            return false;
        }
        if(out1.length!=out2.length){
            return false;
        }
        for(int i=0; i<out1.length; ++i){
            if(out1[i]!=out2[i]){
                return false;
            }
        }
        return true;
    }

    public static int maxLength (int[] arr) {
        // write code here
        int len = arr.length;
        if(len<2){
            return len;
        }
        //哈希表<数字，下标>
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        int begin = 0;
        hm.put(arr[0],0);
        for(int i = 1; i<len; ++i){
            if(hm.containsKey(arr[i])){
                begin = hm.get(arr[i])+1;
                hm.put(arr[i], i);
            } else{
                hm.put(arr[i], i);
            }
            count = i-begin+1>count?(i-begin+1):count;
        }
        return count;
    }
}
