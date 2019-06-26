package com.aditya.personal.circularDependencyBreakSample;

import com.aditya.personal.circularDependencyBreakSample.APIPackage.APICaller;
import com.aditya.personal.circularDependencyBreakSample.APIPackage.APIInit;
import com.aditya.personal.circularDependencyBreakSample.APIPackage.OAuthProvider;
import com.aditya.personal.circularDependencyBreakSample.OAuthPackage.FireAPI;
import com.aditya.personal.circularDependencyBreakSample.OAuthPackage.OAuthInit;
import com.aditya.personal.circularDependencyBreakSample.OAuthPackage.TokenFetcher;

public class App {

    public static void main(String[] args) {
        APICaller caller = APIInit.initCaller(null);
        System.out.println(caller.callAPI(false, "Without", "OAuth"));

        FireAPI apiCallerFunction = (data) -> caller.callAPI(false, data);

        TokenFetcher tokenFetcher = OAuthInit.getOAuth("iam", "carrot", apiCallerFunction);
//        System.out.println(tokenFetcher.fetchToken());

        //noinspection Convert2MethodRef
        OAuthProvider provider = ()-> tokenFetcher.fetchToken();

        // re-init the caller this time with OAuth
        APICaller freshCaller = APIInit.initCaller(provider);
        System.out.println(freshCaller.callAPI(true, "With", "OAuth"));
    }

}
