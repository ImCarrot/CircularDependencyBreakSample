package com.aditya.personal.circularDependencyBreakSample;

import com.aditya.personal.circularDependencyBreakSample.APIPackage.APICaller;
import com.aditya.personal.circularDependencyBreakSample.APIPackage.APIInit;

public class App {

    public static void main(String[] args) {
        APICaller caller = APIInit.initCaller("iam", "carrot");
        System.out.println(caller.callAPI(false, "Without", "OAuth"));
        System.out.println(caller.callAPI(true, "With", "OAuth"));

    }

}
