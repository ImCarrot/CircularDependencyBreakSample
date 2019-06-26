package com.aditya.personal.circularDependencyBreakSample;

import com.aditya.personal.circularDependencyBreakSample.APIPackage.APICaller;
import com.aditya.personal.circularDependencyBreakSample.APIPackage.APIInit;
import com.aditya.personal.circularDependencyBreakSample.OAuthPackage.OAuthInit;
import com.aditya.personal.circularDependencyBreakSample.OAuthPackage.TokenFetcher;

public class App {

    public static void main(String[] args) {
        APICaller caller = APIInit.initCaller(null);
        System.out.println(caller.callAPI(false, "Without", "OAuth"));
//        System.out.println(caller.callAPI(true, "With", "OAuth"));

        TokenFetcher tokenFetcher = OAuthInit.getOAuth(null);
        System.out.println(tokenFetcher.fetchToken("Aditya", "Sharma"));
    }

}
